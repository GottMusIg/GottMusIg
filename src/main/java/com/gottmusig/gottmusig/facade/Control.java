package com.gottmusig.gottmusig.facade;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gottmusig.gottmusig.gateway.SimCraftExecuter;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraft;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraftInputs;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Control {

	private ObjectMapper mapper = new ObjectMapper();
	private SimCraftExecuter simcExecuter = new SimCraftExecuter();

	public SimulationCraft getSimulationCraftData(String region, String server, String user) {

		SimulationCraft simulationcraft = null;
		SimulationCraftInputs inputs = SimulationCraftInputs.builder() //
				.region(region) //
				.server(server) //
				.user(user)//
				.command("calculate_scale_factors=0") //Als command sollte sp�ter n File mitgegeben werden, in dem alle 
													//Einstellungen f�r die Simulation definiert sind.
				.build();

		try {

			File result = simcExecuter.execute(inputs);

			simulationcraft = mapper.readValue(result, SimulationCraft.class);
		//	result.delete();

			
			//Test outputs
			System.out.println(simulationcraft.getSim().getPlayers().get(0).getName());
			System.out.println(simulationcraft.getSim().getPlayers().get(0).getCollectedData().getDps().getMean());

			System.out.println(simulationcraft.getSim().getPlayers().get(0).getCollectedData().getResourceTimelines()
					.get(0).getResource());

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return simulationcraft;

	}
}
