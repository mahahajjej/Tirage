package tn.tirage.dao;

import java.util.List;

import javax.ejb.Local;

import tn.tirage.entities.Tache;

@Local
public interface TacheDAOLocal {
	Tache saveTache(Tache a);
	Tache getTache(Long id);

	List<Tache> getAllTaches();

	void deleteTache(Long id);

	Tache updateTache(Tache a);

}
