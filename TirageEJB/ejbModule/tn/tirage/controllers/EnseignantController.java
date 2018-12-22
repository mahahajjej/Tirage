package tn.tirage.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.tirage.dao.EnseignantDAOLocal;
import tn.tirage.entities.Enseignant;
import tn.tirage.entities.Matiere;
import tn.tirage.utils.HashUtils;

/**
 * Session Bean implementation class EnseignantController
 */
@Stateless
@LocalBean
public class EnseignantController implements EnseignantControllerLocal {

	@EJB
	private EnseignantDAOLocal enseignantDao;

	public EnseignantController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Enseignant ajoutEnseignant(String nomComplet, String login, String password) {
		Enseignant enseignant = null;

		try {
			enseignant = enseignantDao
					.saveEnseignant(new Enseignant(nomComplet, login, HashUtils.hashPasswordSHA1(password)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return enseignant;
	}

	@Override
	public Enseignant getEnseignant(Long id_enseignant) {
		return enseignantDao.getEnseignant(id_enseignant);
	}

	@Override
	public List<Enseignant> getAllEnseignant() {
		return enseignantDao.getAllEnseignants();
	}

	@Override
	public void deleteEnseignant(Long id_enseignant) {
		enseignantDao.deleteEnseignants(id_enseignant);

	}

	@Override
	public Enseignant editEnseignant(Long id_enseignant, String nomComplet, String login, String password, Set<Matiere> matieres) {
		Enseignant ens = new Enseignant();
		ens.setId_enseignant(id_enseignant);
		ens.setLogin(login);
		ens.setNomComplet(nomComplet);
		try {
			ens.setPassword(HashUtils.hashPasswordSHA1(password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		ens.setMatieres(matieres);
		return enseignantDao.updateEnseignant(ens);
	}

}
