package fr.inti.service;

import java.util.List;

import fr.inti.dao.IProfesseurDao;
import fr.inti.dao.ProfesseurDaoImpl;
import fr.inti.entities.Professeur;

public class ProfesseurServiceImpl implements IProfesseurService {
	
	IProfesseurDao prDao= new ProfesseurDaoImpl();

	@Override
	public Professeur ajouterProfesseur(Professeur professeur) {
		// TODO Auto-generated method stub
		return prDao.ajouterProfesseur(professeur);
	}

	@Override
	public Professeur ModifierProfesseur(Professeur professeur) {
		// TODO Auto-generated method stub
		return prDao.ModifierProfesseur(professeur);
	}

	@Override
	public Professeur SupprimerProfesseur(Professeur professeur) {
		// TODO Auto-generated method stub
		return prDao.SupprimerProfesseur(professeur);
	}

	@Override
	public List<Professeur> getAllProfesseurs() {
		// TODO Auto-generated method stub
		return prDao.getAllProfesseurs();
	}

	@Override
	public Professeur getProfesseurById(Professeur professeur) {
		// TODO Auto-generated method stub
		return prDao.getProfesseurById(professeur);
	}

	
}
