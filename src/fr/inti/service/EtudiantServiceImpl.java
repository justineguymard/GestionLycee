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
	public int ModifierEtudiant() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int SupprimerEtudiant() {
		// TODO Auto-generated method stub
		return 0;
	}



}
