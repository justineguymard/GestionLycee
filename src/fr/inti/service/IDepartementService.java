package fr.inti.service;

import java.util.List;

import fr.inti.entities.Departement;

public interface IDepartementService {
	
	public Departement ajouterDepartement(Departement departement);

	public Departement ModifierDepartement(Departement departement);

	public int SupprimerDepartement(Departement departement);
	
	public List<Departement> getAllDepartements();

}
