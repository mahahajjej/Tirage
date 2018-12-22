package tn.tirage.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.tirage.controllers.AgentControllerLocal;
import tn.tirage.entities.Agent;

@Stateless
@Path("/agent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServiceAgent {

	@EJB
	AgentControllerLocal agentService;

	@POST
	public Response ajoutAgent(Agent agent) {
		return Response.ok().entity(agentService.ajoutAgent(agent.getLogin(), agent.getPassword())).build();
	}

	@GET
	@Path("/{id}")
	public Response getAgent(@PathParam("id") Long id) {
		return Response.ok().entity(agentService.getAgent(id)).build();
	}

	@GET
	public Response getAllAgent() {
		return Response.ok().entity(agentService.getAllAgent()).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteAgent(@PathParam("id") Long id) {
		agentService.deleteAgent(id);
		return Response.ok().build();

	}

	@PUT
	@Path("/{id}")
	public Response editAgent(@PathParam("id") Long id, Agent a) {
		return Response.ok().entity(agentService.editAgent(id, a.getLogin(), a.getPassword())).build();
	}
}
