package com.gottmusig.gottmusig.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gottmusig.gottmusig.facade.Control;
import com.gottmusig.gottmusig.model.dpscalculation.SimulationCraft;
import lombok.extern.slf4j.Slf4j;

@Component
@Path("/simulation")
@Slf4j
public class SimCraftDataBoundary {

	@Autowired
	private Control control;

	/**
	 * For Testing try this urls Magier:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=
	 * Blackrock&user=D�sen�ffner Krieger:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=
	 * Blackhand&user=Malahkh Deamonhunter:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=Krag
	 * 'jin&user=Devillin Todesritter:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=
	 * Blackhand&user=Glurak Druide:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=
	 * Blackrock&user=Thodeon Priester:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=
	 * Nemesis&user=Xhopez Schurke:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=
	 * Aegwynn&user=Dexliz Paladin:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=
	 * Arathor&user=Cavyxd M�nch:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=
	 * Arathor&user=Nepho Hexenmeister:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=
	 * Blackrock&user=Plexxi Schamane:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=
	 * Blackrock&user=Ghostkillah Hunter:
	 * http://localhost:8080/gottmusig/simulationcraftdata?region=eu&server=
	 * Aegwynn&user=Imnotdaisy
	 */

	@Path("player")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSimulationCraftData(@QueryParam("region") String region, //
			@QueryParam("realm") String realm, @QueryParam("user") String user) {

		SimulationCraft simulationCraftData = control.getSpecificSimulationCraftData(region, realm, user);
		return Response.status(200).entity(simulationCraftData).build();
	}

	@Path("itemComparison")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response startItemComparisonProcess(@QueryParam("simcVersion") String simcVersion){

		String processId = control.startItemComparisonProcess(simcVersion);
		return Response.ok().entity(processId).build();

	}

	@Path("mainPageDps")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response startMainPageDpsSimulation(@QueryParam("simcVersion") String simcVersion){

		String processId = control.startMainPageDpsSimulation(simcVersion);
		return Response.ok().entity(processId).build();

	}

}
