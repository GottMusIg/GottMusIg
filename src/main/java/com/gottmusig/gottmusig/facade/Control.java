package com.gottmusig.gottmusig.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gottmusig.gottmusig.facade.adapter.processengine.BpeAdapter;
import com.gottmusig.gottmusig.gateway.SimCraftExecuter;
import com.gottmusig.gottmusig.model.dpscalculation.SimcCommands;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraft;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraftInputs;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
@Service
public class Control {

	@Autowired
	private SimCraftExecuter simcExecuter;

	@Autowired
	private BpeAdapter bpeAdapter;

	public String startMainPageDpsSimulation(String simcVersion){
		return bpeAdapter.startMainPageDpsSimulation(simcVersion);
	}

	public String startItemComparisonProcess(String simcVersion){
		return bpeAdapter.startItemRankingCalculation(simcVersion);
	}
	public SimulationCraft getSpecificSimulationCraftData(String region, String server, String user) {

		SimulationCraft simulationcraft = null;

		SimulationCraftInputs inputs = SimulationCraftInputs.builder() //
				.region(region) //
				.server(server) //
				.user(user)//
				.commandType(SimcCommands.SIMULATE_PLAYER)
				.commandString("calculate_scale_factors=0 iterations=300") //TODO
				.build();

		try {
			simulationcraft = simcExecuter.execute(inputs);
			// Test output
			System.out.println(simulationcraft.getSim().getPlayers().get(0).getName());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return simulationcraft;
	}
}
