package fr.inti.dao;

import java.util.List;

import fr.inti.entities.Departement;
import fr.inti.entities.Etudiant;

public interface IEtudiantDao {
	
	
	public Etudiant ajouterEtudiant (Etudiant etudiant);
	
	public Etudiant ModifierEtudiant (Etudiant etudiant);
	
	public int SupprimerEtudiant (Etudiant etudiant);
	
	public Etudiant AssignerDepartement (Etudiant etudiant, Departement departement);
	
	public List<Etudiant> getAllEtudiants ();

}
