package fr.inti.service;

import java.util.List;

import fr.inti.dao.EtudiantDaoImpl;
import fr.inti.dao.IEtudiantDao;
import fr.inti.entities.Departement;
import fr.inti.entities.Etudiant;

public class EtudiantServiceImpl implements IEtudiantService{

	//transformation uml 
	private IEtudiantDao etDao = new EtudiantDaoImpl();
	
	@Override
	public int ajouterEtudiant(Etudiant etudiant) {
		Etudiant etVerif = etDao.ajouterEtudiant(etudiant);
		
		if (etVerif != null ) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int modifierEtudiant(Etudiant etudiant) {
		
		Etudiant etVerif = etDao.modifierEtudiant(etudiant);
		
		if (etVerif != null ) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public int supprimerEtudiant(Etudiant etudiant) {
		Etudiant etVerif = etDao.supprimerEtudiant(etudiant);
		
		if (etVerif != null ) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Etudiant assignerEtudiant(Etudiant etudiant, Departement departement) {
		
		
		
		return etDao.assignerDepartement(etudiant, departement);
	}

	public List<Etudiant> getAllEtudiants() {
		return etDao.getAllEtudiants();
		
	}

	@Override
	public Etudiant getEtudiantById(Etudiant etudiant) {
		// TODO Auto-generated method stub
		return etDao.getEtudiantById(etudiant);
	}


}
