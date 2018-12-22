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

import tn.tirage.controllers.MatiereControllerLocal;
import tn.tirage.entities.Matiere;

@Stateless
@Path("/matiere")
@Produces(MediaType.APPLICATION_JSON)
public class ServiceMatiere {

	@EJB
	MatiereControllerLocal matiereService;

	@POST
	public Response ajoutMatiere(Matiere m) {
		return Response.ok().entity(matiereService.ajoutMatiere(m.getNomMatiere())).build();
	}

	@GET
	@Path("/{id}")
	public Response getMatiere(@PathParam("id") Long id_matiere) {
		return Response.ok().entity(matiereService.getMatiere(id_matiere)).build();

	}

	@GET
	public Response getAllMatieres() {
		return Response.ok().entity(matiereService.getAllMatieres()).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteMatiere(@PathParam("id") Long id_matiere) {
		matiereService.deleteMatiere(id_matiere);
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}")
	public Response editMatiere(@PathParam("id") Long id_matiere, Matiere m) {
		return Response.ok().entity(matiereService.editMatiere(id_matiere,m.getNomMatiere())).build();
	}
}
