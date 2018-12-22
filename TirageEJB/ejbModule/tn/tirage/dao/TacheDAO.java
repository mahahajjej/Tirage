package tn.tirage.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.tirage.entities.Tache;

/**
 * Session Bean implementation class TacheDAO
 */
@Stateless
@LocalBean
public class TacheDAO implements TacheDAOLocal {

	@PersistenceContext
	public EntityManager em;
	
	public TacheDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tache saveTache(Tache t) {
		em.persist(t);
		return t;
	}

	@Override
	public Tache getTache(Long id) {
		Tache t = em.find(Tache.class, id);

		return t;
	}

	@Override
	public List<Tache> getAllTaches() {
		return em.createQuery("from tache", Tache.class).getResultList();
	}

	@Override
	public void deleteTache(Long id) {
		Tache t = em.find(Tache.class, id);

		em.remove(t);

	}

	@Override
	public Tache updateTache(Tache a) {
		Tache t = em.merge(a);
		return t;

	}

}
