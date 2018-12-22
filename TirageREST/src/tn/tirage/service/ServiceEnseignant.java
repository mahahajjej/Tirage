package tn.tirage.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.tirage.controllers.EnseignantControllerLocal;
import tn.tirage.entities.Enseignant;

@Stateless
@Path("/enseignant")
@Produces(MediaType.APPLICATION_JSON)
public class ServiceEnseignant {
	@EJB
	EnseignantControllerLocal serviceEnseignant;

	@POST
	public Response ajoutEnseignant(Enseignant e) {
		return Response.ok().entity(serviceEnseignant.ajoutEnseignant(e.getNomComplet(),e.getLogin(), e.getPassword())).build();
	}

	@GET
	@Path("/{id}")
	public Response getEnseignant(@PathParam("id") Long id_enseignant) {
		return Response.ok().entity(serviceEnseignant.getEnseignant(id_enseignant)).build();
	}

	@GET
	public Response getAllEnseignant() {
		return Response.ok().entity(serviceEnseignant.getAllEnseignant()).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEnseignant(@PathParam("id") Long id_enseignant) {
		serviceEnseignant.deleteEnseignant(id_enseignant);
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}")
	public Response editEnseignant(@PathParam("id") Long id_enseignant, Enseignant e) {
		return Response.ok().entity(serviceEnseignant.editEnseignant(id_enseignant, e.getNomComplet(), e.getLogin(),
				e.getPassword(), e.getMatieres())).build();
	}
}
