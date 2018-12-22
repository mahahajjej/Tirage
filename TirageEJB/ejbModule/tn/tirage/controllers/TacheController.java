package tn.tirage.controllers;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.tirage.dao.TacheDAOLocal;
import tn.tirage.entities.Enseignant;
import tn.tirage.entities.Matiere;
import tn.tirage.entities.Tache;

/**
 * Session Bean implementation class TacheController
 */
@Stateless
@LocalBean
public class TacheController implements TacheControllerLocal {

	@EJB
	private TacheDAOLocal tacheDao;

	public TacheController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tache ajoutTache(String nomFichier, int nombreCopies, Date dateTirage, Enseignant enseignant, Matiere matiere) {
		return tacheDao.saveTache(new Tache(nomFichier, nombreCopies, dateTirage, enseignant, matiere));
	}

	@Override
	public Tache getTache(Long id) {
		return tacheDao.getTache(id);
	}

	@Override
	public List<Tache> getAllTache() {
		return tacheDao.getAllTaches();
	}

	@Override
	public void deleteTache(Long id) {
		tacheDao.deleteTache(id);
	}

	@Override
	public Tache editTache(Long id,String nomFichier, int nombreCopies, Date dateTirage, Enseignant enseignant, Matiere matiere) {
		Tache t = new Tache();
		t.setId(id);
		t.setDateTirage(dateTirage);
		t.setNomFichier(nomFichier);
		t.setNombreCopies(nombreCopies);
		t.setEnseignant(enseignant);
		t.setMatiere(matiere);
		return tacheDao.updateTache(t);
	}

}
