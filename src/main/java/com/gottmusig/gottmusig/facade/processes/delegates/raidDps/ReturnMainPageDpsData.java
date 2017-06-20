package com.gottmusig.gottmusig.facade.processes.delegates.raidDps;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;
import com.gottmusig.gottmusig.facade.processes.vars.ProcessVars;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraft;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReturnMainPageDpsData implements JavaDelegate {

    @Override public void execute(DelegateExecution execution) throws Exception {

        SimulationCraft simulationCraft = (SimulationCraft) execution.getVariable(ProcessVars.SIMULATIONCRAFT);
        log.debug(simulationCraft.getSim().getPlayers().get(0).getName());
        log.debug(""+simulationCraft.getSim().getPlayers().get(0).getCollectedData().getDps().getMean());
        //

    }
}
