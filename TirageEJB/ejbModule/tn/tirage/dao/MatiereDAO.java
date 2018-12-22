package tn.tirage.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.tirage.entities.Matiere;

/**
 * Session Bean implementation class MatiereDAO
 */
@Stateless
@LocalBean
public class MatiereDAO implements MatiereDAOLocal {
	@PersistenceContext
	public EntityManager em;

	@Override
	public Matiere saveMatiere(Matiere m) {
		em.persist(m);
		return m;
	}

	@Override
	public Matiere getMatiere(Long id_matiere) {
	Matiere m = em.find(Matiere.class, id_matiere);

		return m;
	}

	@Override
	public List<Matiere> getAllMatieres() {
		return em.createQuery("from matiere", Matiere.class).getResultList();
		}
	

	@Override
	public void deleteMatiere(Long id_matiere) {
	Matiere m = em.find(Matiere.class, id_matiere);

		em.remove(m);
		
	}

	@Override
	public Matiere updateMatiere(Matiere a) {
		Matiere m = em.merge(a);
		return m;
	}

 

}
