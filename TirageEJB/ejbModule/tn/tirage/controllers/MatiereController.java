package tn.tirage.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.tirage.dao.MatiereDAOLocal;
import tn.tirage.entities.Matiere;

/**
 * Session Bean implementation class MatiereController
 */
@Stateless
@LocalBean
public class MatiereController implements MatiereControllerLocal {

	@EJB
	private MatiereDAOLocal matiereDao;
	
    public MatiereController() {
        // TODO Auto-generated constructor stub
    }
	

	@Override
	public Matiere ajoutMatiere(String nomMatiere) {
	
		return matiereDao.saveMatiere(new Matiere(nomMatiere));
	}
	@Override
	public Matiere getMatiere(Long id_matiere) {
		return matiereDao.getMatiere(id_matiere);
	}
	@Override
	public List<Matiere> getAllMatieres() {
		return matiereDao.getAllMatieres();
	}
	@Override
	public void deleteMatiere(Long id_matiere) {
		matiereDao.deleteMatiere(id_matiere);
		
	}
	@Override
	public Matiere editMatiere(Long id_matiere,String nomMatiere) {
		Matiere m = new Matiere();
		m.setId_matiere(id_matiere);
		m.setNomMatiere(nomMatiere);
		return 	matiereDao.updateMatiere(m);
	}
}
