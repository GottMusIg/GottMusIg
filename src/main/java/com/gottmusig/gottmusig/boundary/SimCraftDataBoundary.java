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

	@Path("player")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSimulationCraftData(@QueryParam("region") String region, //
			@QueryParam("server") String server, @QueryParam("user") String user) {

		SimulationCraft simulationCraftData = control.getSpecificSimulationCraftData(region, server, user);
		return Response.ok().entity(simulationCraftData).build();
	}

	@Path("itemComparison")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response testCamunda(@QueryParam("simcVersion") String simcVersion){

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
