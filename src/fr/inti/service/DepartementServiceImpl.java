package fr.inti.service;

import java.util.List;

import fr.inti.entities.Departement;

public class DepartementServiceImpl implements IDepartementService{
	
	//Transformation uml en java
	
	IDepartementService depDao= new DepartementServiceImpl();

	@Override
	public Departement ajouterDepartement(Departement departement) {
		// TODO Auto-generated method stub
		return depDao.ajouterDepartement(departement);
	}

	@Override
	public Departement ModifierDepartement(Departement departement) {
		
		return depDao.ModifierDepartement(departement);
		
	
	}

	@Override
	public Departement SupprimerDepartement(Departement departement) {
		// TODO Auto-generated method stub
		return depDao.ModifierDepartement(departement);
		
	}

	@Override
	public List<Departement> getAllDepartements() {
		// TODO Auto-generated method stub
		return depDao.getAllDepartements();
	}

}
