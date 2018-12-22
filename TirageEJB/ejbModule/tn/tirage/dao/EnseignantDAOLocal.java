package tn.tirage.dao;

import java.util.List;

import javax.ejb.Local;

import tn.tirage.entities.Enseignant;

@Local
public interface EnseignantDAOLocal {
	Enseignant saveEnseignant(Enseignant e);

	Enseignant getEnseignant(Long id_enseignant);

	List<Enseignant> getAllEnseignants();

	void deleteEnseignants(Long id_enseignant);

	Enseignant updateEnseignant(Enseignant e);

}
