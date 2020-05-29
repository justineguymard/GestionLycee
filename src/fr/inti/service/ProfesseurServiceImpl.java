package fr.inti.service;

import java.util.List;

import fr.inti.dao.IProfesseurDao;
import fr.inti.dao.ProfesseurDaoImpl;
import fr.inti.entities.Departement;
import fr.inti.entities.Matiere;
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

	@Override
	public Professeur AssignerDepartement(Professeur professeur, Departement departement) {
		// TODO Auto-generated method stub
		return prDao.AssignerDepartement(professeur, departement);
	}

	@Override
	public Professeur AssignerMatiere(Professeur professeur, Matiere matiere) {
		// TODO Auto-generated method stub
		return prDao.AssignerMatiere(professeur, matiere);
	}

	
}
