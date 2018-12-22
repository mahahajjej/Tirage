package tn.tirage.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.tirage.entities.Agent;

/**
 * Session Bean implementation class AgentDAO
 */
@Stateless
@LocalBean
public class AgentDAO implements AgentDAOLocal {

	@PersistenceContext
	public EntityManager em;
    public AgentDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Agent saveAgent(Agent a) {
		em.persist(a);
		return a;
	}

	@Override
	public Agent getAgent(Long id) {
		Agent a = em.find(Agent.class, id);

		return a;
	}

	@Override
	public List<Agent> getAllAgents() {
		return em.createQuery("from agent", Agent.class).getResultList();
	}

	@Override
	public void deleteAgent(Long id) {
		Agent a = em.find(Agent.class, id);

		em.remove(a);
		
	}

	@Override
	public Agent updateAgent(Agent ag) {
		Agent a = em.merge(ag);
		return a;
	}

}
