package fr.inti.service;

import java.util.List;

import fr.inti.dao.DepartementDaoImpl;
import fr.inti.dao.IDepartementDao;
import fr.inti.entities.Departement;

public class DepartementServiceImpl implements IDepartementService{
	
	//Transformation uml en java
	
	IDepartementDao depDao= new DepartementDaoImpl();
	
	@Override
	public Departement ajouterDepartement(Departement departement) {
	
	return depDao.AjouterDepartement(departement);
}

	@Override
	public Departement ModifierDepartement(Departement departement) {
		
		return depDao.ModifierDepartement(departement);
		
	
	}

	@Override
	public int SupprimerDepartement(Departement departement) {
		int verif = 0;
		if (departement != null) {
			verif++;
			depDao.SupprimerDepartement(departement);
			return verif;
		}else {
			return verif;
		}
		
	}

	@Override
	public List<Departement> getAllDepartements() {
		// TODO Auto-generated method stub
		return depDao.getAllDepartements();
	}

	@Override
	public Departement getDepartementById(Departement departement) {
		
		return depDao.getDepartementById(departement);
	}

}
