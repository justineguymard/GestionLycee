package fr.inti.service;

import java.util.List;

import fr.inti.entities.Departement;
import fr.inti.entities.Professeur;

public interface IProfesseurService {

	public Professeur ajouterProfesseur(Professeur professeur);

	public Professeur ModifierProfesseur(Professeur professeur);

	public Professeur SupprimerProfesseur(Professeur professeur);

	public List<Professeur> getAllProfesseurs();

	public Professeur getProfesseurById(Professeur professeur);
	
	public Professeur AssignerDepartement(Professeur professeur,Departement departement);

}
