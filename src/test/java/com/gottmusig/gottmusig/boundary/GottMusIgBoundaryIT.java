package com.gottmusig.gottmusig.boundary;

import java.io.IOException;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraft;
import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.*;

@RunAsClient
@RunWith(Arquillian.class)
@Slf4j
public class GottMusIgBoundaryIT extends AbstractIT {
	
	@Test
	public void shouldGetStartPageTest(){
		String response = get("/rest");
		log.debug("Response for Hello WorldTest: "+response);
		approve(response, "htmlStartpage");
	}
	
	@Test
	public void shouldGetJsonForSimulation() throws IOException {
		String playerName = "Døsenöffner";
		String response = get("/rest/simulation/player?realm=Blackrock&user="+playerName+"&region=eu");

		SimulationCraft simulationCraft = (SimulationCraft) getObject(response.toString(), SimulationCraft.class);
		assertEquals(simulationCraft.getSim().getPlayers().get(0).getName(), playerName);

	}

}
