package com.gottmusig.gottmusig.gateway;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gottmusig.gottmusig.model.dpscalculation.SimcCommands;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraft;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraftInputs;
import com.gottmusig.gottmusig.model.wowhead.ClassSpec;
import com.gottmusig.gottmusig.model.wowhead.Classes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@PropertySource("classpath:simc.properties")
public class SimCraftExecuter {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private Environment env;

    @Autowired
    public SimCraftExecuter(Environment env, @Value("${SIMULATION_CRAFT_TMP_RESULTS_DIR}") String tmp_result, @Value("${SIMULATION_CRAFT_TMP_PROFILES_DIR}") String tmp_profile) {
        log.info("---------------------------->"+env.getRequiredProperty("SIMULATION_CRAFT_TMP_RESULTS_DIR"));
        checkForExistingDir(tmp_result);
        checkForExistingDir(tmp_profile);
    }

    private void checkForExistingDir(String dirPath) {
        File simcraftResultDir = new File(dirPath);
        if (!simcraftResultDir.exists()) {
            simcraftResultDir.mkdir();
        }
    }

    public SimulationCraft execute(SimulationCraftInputs inputs) throws Exception {

        File jsonResult = createFile(env.getRequiredProperty("SIMULATION_CRAFT_TMP_RESULTS_DIR"), env.getRequiredProperty("JSON"));
        File simcProfile = createFile(env.getRequiredProperty("SIMULATION_CRAFT_TMP_PROFILES_DIR"), env.getRequiredProperty("SIMC"));

        SimulationCraft simulationcraft = null;
        String simcExecutionString = "";

        if (inputs.simulateAndCompareItems()) {

            File standartProfile = getMatchingProfileFile(inputs.getClazz(), inputs.getSpec());
            simcExecutionString = "\"" + standartProfile.getAbsolutePath() + "\" " + inputs.getCommandString() + " " + SimcCommands.RESULT
                    .getCommand() + jsonResult.getAbsolutePath();

        } else {

            if(inputs.simulatePlayer()){
                simcExecutionString =
                        SimcCommands.ARMORY.getCommand() + "\"" + inputs.getRegion() + "," + inputs.getServer() + "," + inputs
                                .getUser() + "\" " + inputs.getCommandString() + " " + SimcCommands.RESULT.getCommand() + jsonResult
                                .getAbsolutePath();
            } else {

                File raidFile = new File(env.getRequiredProperty("SIMULATION_CRAFT_RAID_FILE"));
                simcExecutionString = "\"" + raidFile.getAbsolutePath() + "\" " + SimcCommands.RESULT
                        .getCommand() + jsonResult.getAbsolutePath();
            }
        }

        Files.write(simcProfile.toPath(), simcExecutionString.getBytes());

        String command = env.getRequiredProperty("RUN_SIMC")+"\"" + simcProfile.getAbsolutePath() + "\"";
        ProcessBuilder builder = new ProcessBuilder(env.getRequiredProperty("CMD"), "/"+env.getRequiredProperty("PARTITION"), command);

        simulationcraft = getSimulationCraftData(builder, jsonResult);

        simcProfile.delete();
        jsonResult.delete();
        return simulationcraft;
    }

    private SimulationCraft getSimulationCraftData(ProcessBuilder builder, File jsonResult) throws IOException {

        builder.redirectErrorStream(true);
        builder.directory(new File(env.getRequiredProperty("SIMULATION_CRAFT_DIR")));

        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            log.debug(line);
        }
        return unmarshallJson(jsonResult);
    }

    private File createFile(String location, String type) throws IOException {
        UUID uuid = UUID.randomUUID();
        File file = new File(location+"/"+uuid.toString()+type);
        file.createNewFile();
        return file;
    }

    private SimulationCraft unmarshallJson(File jsonFile) {
        SimulationCraft simulationcraft = null;
        try {
            simulationcraft = mapper.readValue(jsonFile, SimulationCraft.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return simulationcraft;
    }

    private File getMatchingProfileFile(Classes clazz, ClassSpec spec) throws Exception {

        File file = new File(env.getRequiredProperty("SIMULATION_CRAFT_STANDARD_PROFILES_DIR"));
                for (File profile : file.listFiles()) {

                    String fileName = profile.getName().toLowerCase();

                    if (fileName.startsWith(clazz.name().toLowerCase()) && fileName.contains(spec.name().toLowerCase())) {
                        return profile;
                    }
                }

        throw new Exception("Could not find a profile for: " + clazz.name() + ", " + spec.name()); //TODO

    }

}
