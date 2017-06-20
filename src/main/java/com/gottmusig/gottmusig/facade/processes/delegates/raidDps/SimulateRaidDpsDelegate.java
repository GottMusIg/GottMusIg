package com.gottmusig.gottmusig.facade.processes.delegates.raidDps;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gottmusig.gottmusig.facade.processes.vars.ProcessVars;
import com.gottmusig.gottmusig.gateway.SimCraftExecuter;
import com.gottmusig.gottmusig.model.dpscalculation.SimcCommands;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraft;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraftInputs;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SimulateRaidDpsDelegate implements JavaDelegate {

    @Autowired
    private SimCraftExecuter simCraftExecuter;

    @Override
    public void execute(DelegateExecution execution) throws Exception {


        SimulationCraftInputs inputs = SimulationCraftInputs.builder() //
                .commandType(SimcCommands.SIMULATE_RAID) //
                .build();

        SimulationCraft simulationCraft = simCraftExecuter.execute(inputs);

        execution.setVariable(ProcessVars.SIMULATIONCRAFT, simulationCraft);



    }
}
