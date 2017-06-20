package com.gottmusig.gottmusig.gateway;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gottmusig.gottmusig.model.dpscalculation.SimcCommands;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraft;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraftInputs;
import com.gottmusig.gottmusig.model.wowhead.ClassSpec;
import com.gottmusig.gottmusig.model.wowhead.Classes;
import lombok.extern.slf4j.Slf4j;

@Slf4j @Service public class SimCraftExecuter {

    // TODO ACHTUNG KEINE LEERZEICHEN IM PFAD -- SIMC IST BEHINDERT
    private static final String ROOT_DIR = "C://Softwareengineering/";

    private static final String SIMC_VERSION = "720-02";

    private static final String SIMULATION_CRAFT_DIR = ROOT_DIR + "Simulationcraft/" + SIMC_VERSION;

    private static final String SIMULATION_CRAFT_STANDARD_PROFILES_DIR = SIMULATION_CRAFT_DIR + "/profiles/";

    private static final String SIMULATION_CRAFT_RESULTS_DIR = ROOT_DIR + "Results";

    private static final String SIMULATION_CRAFT_PROFILES_DIR = ROOT_DIR + "Profiles";

    private static final String MYTHIC = "M";

    private static final String RAID = "Raid";

    private static final String JSON = ".json";

    private static final String SIMC = ".simc";

    private ObjectMapper mapper = new ObjectMapper();

    public SimCraftExecuter() {
        checkForExistingDir(SIMULATION_CRAFT_RESULTS_DIR);
        checkForExistingDir(SIMULATION_CRAFT_PROFILES_DIR);
    }

    private void checkForExistingDir(String dirPath) {
        File simcraftResultDir = new File(dirPath);
        if (!simcraftResultDir.exists()) {
            simcraftResultDir.mkdir();
        }
    }

    public SimulationCraft execute(SimulationCraftInputs inputs) throws Exception {

        File jsonResult = createFile(SIMULATION_CRAFT_RESULTS_DIR, JSON);
        File simcProfile = createFile(SIMULATION_CRAFT_PROFILES_DIR, SIMC);

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

                File raidFile = getRaidFile();
                simcExecutionString = "\"" + raidFile.getAbsolutePath() + "\" " + SimcCommands.RESULT
                        .getCommand() + jsonResult.getAbsolutePath();
            }
        }

        Files.write(simcProfile.toPath(), simcExecutionString.getBytes());

        String command = "simc.exe input=\"" + simcProfile.getAbsolutePath() + "\"";
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);

        simulationcraft = getSimulationCraftData(builder, jsonResult);

        simcProfile.delete();
        jsonResult.delete();
        return simulationcraft;
    }

    private SimulationCraft getSimulationCraftData(ProcessBuilder builder, File jsonResult) throws IOException {

        builder.redirectErrorStream(true);
        builder.directory(new File(SIMULATION_CRAFT_DIR));

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

    private File getRaidFile() throws Exception {

        File[] files = new File(SIMULATION_CRAFT_STANDARD_PROFILES_DIR).listFiles();

        for (File file : files) {
            if (file.isDirectory() && file.getName().contains(MYTHIC)) {

                for (File profile : file.listFiles()) {

                    String fileName = profile.getName().toLowerCase();

                    if (fileName.startsWith(RAID.toLowerCase()) && fileName.contains(MYTHIC.toLowerCase())) {
                        return profile;
                    }
                }
            }
        }
        throw new Exception("TODO");
    }

    private File getMatchingProfileFile(Classes clazz, ClassSpec spec) throws Exception {

        File[] files = new File(SIMULATION_CRAFT_STANDARD_PROFILES_DIR).listFiles();

        for (File file : files) {
            if (file.isDirectory() && file.getName().contains(MYTHIC)) {

                for (File profile : file.listFiles()) {

                    String fileName = profile.getName().toLowerCase();

                    if (fileName.startsWith(clazz.name().toLowerCase()) && fileName.contains(spec.name().toLowerCase())) {
                        return profile;
                    }
                }
            }
        }

        throw new Exception("Could not find a profile for: " + clazz.name() + ", " + spec.name()); //TODO

    }

}
