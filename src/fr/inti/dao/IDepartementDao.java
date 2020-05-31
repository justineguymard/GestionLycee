package fr.inti.dao;

import java.util.List;

import fr.inti.entities.Departement;


public interface IDepartementDao {
	
	public Departement AjouterDepartement(Departement departement);
	
	public Departement ModifierDepartement (Departement departement);
	
	public void SupprimerDepartement(Departement departement);

	public List<Departement> getAllDepartements ();

	public Departement getDepartementById(Departement departement);
}
