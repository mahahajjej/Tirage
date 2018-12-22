package tn.tirage.controllers;

import java.util.List;

import javax.ejb.Local;

import tn.tirage.entities.Matiere;

@Local
public interface MatiereControllerLocal {
	Matiere ajoutMatiere(String nomMatiere);

	Matiere getMatiere(Long id_matiere);

	List<Matiere> getAllMatieres();

	void deleteMatiere(Long id_matiere);

	Matiere editMatiere(Long id_matiere, String nomMatiere);

}
