package fr.inti.service;

import java.util.List;

import fr.inti.entities.Matiere;

public class MatiereServiceImpl implements IMatiereService {
	
	IMatiereService matDao= new MatiereServiceImpl();

	@Override
	public Matiere ajouterMatiere(Matiere matiere) {
		// TODO Auto-generated method stub
		return matDao.ajouterMatiere(matiere);
	}

	@Override
	public Matiere ModifierMatiere(Matiere matiere) {
		// TODO Auto-generated method stub
		return matDao.ModifierMatiere(matiere);
	}

	@Override
	public Matiere SupprimerMatiere(Matiere matiere) {
		// TODO Auto-generated method stub
		return matDao.SupprimerMatiere(matiere);
	}

	@Override
	public List<Matiere> getAllMatieres() {
		// TODO Auto-generated method stub
		return matDao.getAllMatieres();
	}

}
