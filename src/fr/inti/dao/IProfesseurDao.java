package fr.inti.dao;

import java.util.List;

import fr.inti.entities.Departement;
import fr.inti.entities.Matiere;
import fr.inti.entities.Professeur;

public interface IProfesseurDao {
	
public Professeur ajouterProfesseur (Professeur professeur);
	
	public Professeur ModifierProfesseur (Professeur professeur);
	
	public Professeur SupprimerProfesseur (Professeur professeur);
	
	public Professeur AssignerDepartement(Professeur professeur,Departement departement);
	
	public Professeur AssignerMatiere(Professeur professeur,Matiere matiere);
	
	public List<Professeur> getAllProfesseurs();
	
	public Professeur getProfesseurById(Professeur professeur);

}
