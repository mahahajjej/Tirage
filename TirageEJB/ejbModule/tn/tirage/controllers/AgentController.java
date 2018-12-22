package tn.tirage.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.tirage.dao.AgentDAOLocal;
import tn.tirage.entities.Agent;
import tn.tirage.utils.HashUtils;

/**
 * Session Bean implementation class AgentController
 */
@Stateless
@LocalBean
public class AgentController implements AgentControllerLocal {
	@EJB
	private AgentDAOLocal agentDao;

	public AgentController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Agent ajoutAgent(String login, String password) {
		Agent agent = null;
		try {
			agent = agentDao.saveAgent(new Agent(login, HashUtils.hashPasswordSHA1(password)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return agent;
	}

	@Override
	public Agent getAgent(Long id) {
		return agentDao.getAgent(id);
	}

	@Override
	public List<Agent> getAllAgent() {
		return agentDao.getAllAgents();
	}

	@Override
	public void deleteAgent(Long id) {
		agentDao.deleteAgent(id);
	}

	@Override
	public Agent editAgent(Long id, String login, String password) {
		Agent a = new Agent();
		a.setId(id);
		a.setLogin(login);
		try {
			a.setPassword(HashUtils.hashPasswordSHA1(password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return agentDao.updateAgent(a);
	}
}
