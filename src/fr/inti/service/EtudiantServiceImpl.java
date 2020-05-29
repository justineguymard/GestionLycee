package fr.inti.service;

import fr.inti.dao.EtudiantDaoImpl;
import fr.inti.dao.IEtudiantDao;
import fr.inti.entities.Etudiant;

public class EtudiantServiceImpl implements IEtudiantService{

	//transformation uml 
	private IEtudiantDao etDao = new EtudiantDaoImpl();
	
	@Override
	public Etudiant ajouterEtudiant(Etudiant etudiant) {
		return etDao.ajouterEtudiant(etudiant);
	}

	@Override
	public int ModifierEtudiant(Etudiant etudiant) {
		
		Etudiant etVerif = etDao.ModifierEtudiant(etudiant);
		
		if (etVerif != null ) {
			return 1;
		} else {
			return 0;
		}
		
		
	}
	
	
	@Override
	public Etudiant ModifierEtudiant2(Etudiant etudiant) {
		// TODO Auto-generated method stub
		return etDao.ModifierEtudiant(etudiant);
	}

	@Override
	public int SupprimerEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		return etDao.SupprimerEtudiant(etudiant);
	}




}
