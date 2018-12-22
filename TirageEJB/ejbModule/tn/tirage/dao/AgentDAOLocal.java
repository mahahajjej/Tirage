package tn.tirage.dao;

import java.util.List;

import javax.ejb.Local;

import tn.tirage.entities.Agent;



@Local
public interface AgentDAOLocal {
	Agent saveAgent(Agent a);

	Agent getAgent(Long id);

	List<Agent> getAllAgents();

	void deleteAgent(Long id);

	Agent updateAgent(Agent a);

}
