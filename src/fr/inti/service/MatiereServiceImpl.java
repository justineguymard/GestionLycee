package fr.inti.service;

import java.util.List;

import fr.inti.dao.IMatiereDao;
import fr.inti.dao.MatiereDaoImpl;
import fr.inti.entities.Matiere;

public class MatiereServiceImpl implements IMatiereService {
	
	private IMatiereDao matDao= new MatiereDaoImpl();

	@Override
	public Matiere ajouterMatiere(Matiere matiere) {
		return matDao.AjouterMatiere(matiere);
	}

	@Override
	public Matiere ModifierMatiere(Matiere matiere) {
		return matDao.ModifierMatiere(matiere);
	}

	@Override
	public int SupprimerMatiere (Matiere matiere) {
		if (matiere != null) {
			matDao.SupprimerMatiere(matiere);
			return 1;
		} else {
			return 0;
		}
		
	}

	@Override
	public List<Matiere> getAllMatieres() {
		return matDao.getAllMatieres();
	}

	@Override
	public Matiere getMatiereById(Matiere matiere) {
		// TODO Auto-generated method stub
		return matDao.getMatiereById(matiere);
	}

}
