package tn.tirage.controllers;

import java.util.List;

import javax.ejb.Local;

import tn.tirage.entities.Agent;

@Local
public interface AgentControllerLocal {

	Agent ajoutAgent(String login,String password);

	Agent getAgent(Long id);

	List<Agent> getAllAgent();

	void deleteAgent(Long id);

	Agent editAgent(Long id,String login,String password);
}
