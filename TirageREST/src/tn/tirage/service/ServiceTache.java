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
import tn.tirage.controllers.MatiereControllerLocal;
import tn.tirage.controllers.TacheControllerLocal;
import tn.tirage.entities.Tache;

@Stateless
@Path("/tache")
@Produces(MediaType.APPLICATION_JSON)
public class ServiceTache {
	@EJB
	TacheControllerLocal tacheService;
	@EJB
	EnseignantControllerLocal enseignantController;
	@EJB
	MatiereControllerLocal matiereController;

	@POST
	@Path("/enseignant/{id_ens}/matiere/{id_mat}")
	public Response ajoutTache(@PathParam("id_ens") Long id_ens, @PathParam("id_mat") Long id_mat,Tache t) {
		return Response.ok().entity(tacheService.ajoutTache(t.getNomFichier(), t.getNombreCopies(), t.getDateTirage(), enseignantController.getEnseignant(id_ens), matiereController.getMatiere(id_mat))).build();
	}

	@GET
	@Path("/{id}")
	public Response getTache(@PathParam("id") Long id) {
		return Response.ok().entity(tacheService.getTache(id)).build();
	}

	@GET
	public Response getAllTache() {
		return Response.ok().entity(tacheService.getAllTache()).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteTache(@PathParam("id") Long id) {
		tacheService.deleteTache(id);
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}")
	public Response editTache(@PathParam("id") Long id,Tache t) {
		return Response.ok().entity(tacheService.editTache(id,t.getNomFichier(),t.getNombreCopies(),t.getDateTirage(),t.getEnseignant(),t.getMatiere()))
				.build();
	}

}
