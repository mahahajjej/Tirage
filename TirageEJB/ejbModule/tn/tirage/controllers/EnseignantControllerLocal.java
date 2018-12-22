package tn.tirage.controllers;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import tn.tirage.entities.Enseignant;
import tn.tirage.entities.Matiere;

@Local
public interface EnseignantControllerLocal {
	Enseignant ajoutEnseignant(String nomComplet, String login, String password);

	Enseignant getEnseignant(Long id_enseignant);

	List<Enseignant> getAllEnseignant();

	void deleteEnseignant(Long id_enseignant);

	Enseignant editEnseignant(Long id_enseignant, String nomComplet, String login, String password,
			Set<Matiere> matieres);

}
