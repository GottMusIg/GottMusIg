package com.gottmusig.gottmusig.facade.processes.delegates.itemRanking.sub;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;
import com.gottmusig.gottmusig.facade.processes.vars.ProcessVars;
import com.gottmusig.gottmusig.model.dpscalculation.Player;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraft;
import com.gottmusig.gottmusig.model.wowhead.WowHeadItem;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreateItemDpsRankingDelegate implements JavaDelegate {

    @Override public void execute(DelegateExecution execution) throws Exception {

        List<WowHeadItem> items = (List<WowHeadItem>) execution.getVariable(ProcessVars.WOW_HEAD_ITEMS);
        SimulationCraft simc = (SimulationCraft) execution.getVariable(ProcessVars.SIMULATIONCRAFT);



        Map<WowHeadItem, Double> dpsPerItem = new HashMap<WowHeadItem, Double>();

        for (Player simulatedItem : simc.getSim().getPlayers()) {

            String simulationName = simulatedItem.getName();

            for (WowHeadItem item : items) {
                if (simulationName.equals(item.getSimulationName())) {
                    dpsPerItem.put(item, simulatedItem.getCollectedData().getDps().getMean());
                }

            }
        }

        dpsPerItem = sortMapByDps(dpsPerItem);

        log.debug(items.size() + "vs" + dpsPerItem.size());

        for (Map.Entry<WowHeadItem, Double> itemByDps : dpsPerItem.entrySet()) {
            log.debug(itemByDps.getKey().getName() + " --> " + itemByDps.getValue());
            log.debug("URL for wowhead: " + itemByDps.getKey().getWowHeadToolTipLink());
        }

        List<Map<WowHeadItem, Double>> simulationResults = (List<Map<WowHeadItem, Double>>) execution.getVariable(ProcessVars.SIMULATION_RESULT_LIST);
        simulationResults.add(dpsPerItem);
        execution.setVariable(ProcessVars.SIMULATION_RESULT_LIST, simulationResults);
    }

    private Map<WowHeadItem, Double> sortMapByDps(Map<WowHeadItem, Double> map) {
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }
}
