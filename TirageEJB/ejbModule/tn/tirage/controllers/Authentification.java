package tn.tirage.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.tirage.dao.AgentDAOLocal;
import tn.tirage.dao.EnseignantDAOLocal;
import tn.tirage.entities.Agent;
import tn.tirage.entities.Enseignant;
import tn.tirage.utils.HashUtils;

@Stateless
@LocalBean
public class Authentification implements AuthentificationLocal {

	@EJB
	private EnseignantDAOLocal enseignantDao;
	@EJB
	private AgentDAOLocal agentDao;

	public Authentification() {
	}

	public String authentication(String login, String password) {
		
		String hashedPassword = "";
		
		try {
			hashedPassword = HashUtils.hashPasswordSHA1(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		List<Agent> agents = agentDao.getAllAgents();
		
		for(Agent agent:agents) {
			if(agent.getPassword().equals(hashedPassword) && agent.getLogin().equals(login)) {
				return "A"+agent.getId()+"/"+login;
			}
		}
		
		List<Enseignant> enseignants = enseignantDao.getAllEnseignants();

		for(Enseignant enseignant:enseignants) {
			if(enseignant.getPassword().equals(hashedPassword) && enseignant.getLogin().equals(login)) {
				return "E"+enseignant.getId_enseignant()+"/"+login;
			}
		}
		
		return null;
	}
	
}
