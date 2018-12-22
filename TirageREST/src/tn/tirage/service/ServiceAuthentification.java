package tn.tirage.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import tn.tirage.controllers.Authentification;

@Stateless
@Path("/authentification")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class ServiceAuthentification {
	
	@EJB
	private Authentification authentificationService;

	private ObjectMapper mapper = new ObjectMapper();
	
	@POST
	public Response authentication(@FormParam("login") String login, @FormParam("password") String password) {
		
		JsonNode response = mapper.createObjectNode();
		String auth = "";
		
		if((auth = authentificationService.authentication(login, password)) == null) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
		
		boolean isAgent = auth.startsWith("A");
		String id = auth.substring(1, auth.indexOf("/"));
		
		((ObjectNode) response).put("isAgent", isAgent);
		((ObjectNode) response).put("id", id);
		
		return Response.ok().entity(response).build();
	}

}
