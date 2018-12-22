package tn.tirage.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.tirage.entities.Enseignant;

/**
 * Session Bean implementation class EnseignantDAO
 */
@Stateless
@LocalBean
public class EnseignantDAO implements EnseignantDAOLocal {
	@PersistenceContext
	public EntityManager em;
	
	public EnseignantDAO() {
	}

	@Override
	public Enseignant saveEnseignant(Enseignant e) {
		em.persist(e);
		return e;
	}

	@Override
	public Enseignant getEnseignant(Long id_enseignant) {
		Enseignant e = em.find(Enseignant.class, id_enseignant);

		return e;
	}

	@Override
	public List<Enseignant> getAllEnseignants() {
		return em.createQuery("from enseignant", Enseignant.class).getResultList();
	}

	@Override
	public void deleteEnseignants(Long id_enseignant) {
		Enseignant e = em.find(Enseignant.class, id_enseignant);

		em.remove(e);
		
	}

	@Override
	public Enseignant updateEnseignant(Enseignant en) {
		Enseignant e = em.merge(en);
		return e;
	}

	
}
