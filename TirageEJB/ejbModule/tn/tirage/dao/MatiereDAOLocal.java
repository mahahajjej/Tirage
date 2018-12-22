package tn.tirage.dao;

import java.util.List;

import javax.ejb.Local;

import tn.tirage.entities.Matiere;



@Local
public interface MatiereDAOLocal {
	Matiere saveMatiere(Matiere m);

	Matiere getMatiere(Long id_matiere);

	List<Matiere> getAllMatieres();

	void deleteMatiere(Long id_matiere);

	Matiere updateMatiere(Matiere m);

}
