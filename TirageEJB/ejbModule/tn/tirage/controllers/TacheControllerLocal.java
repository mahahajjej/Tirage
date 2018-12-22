package tn.tirage.controllers;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.tirage.entities.Enseignant;
import tn.tirage.entities.Matiere;
import tn.tirage.entities.Tache;

@Local
public interface TacheControllerLocal {
	Tache ajoutTache(String nomFichier, int nombreCopies, Date dateTirage, Enseignant enseignant, Matiere matiere);

	Tache getTache(Long id);

	List<Tache> getAllTache();

	void deleteTache(Long id);

	Tache editTache(Long id,String nomFichier, int nombreCopies, Date dateTirage, Enseignant enseignant, Matiere matiere);

}
