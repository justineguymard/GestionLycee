package fr.inti.dao;

import java.util.List;

import fr.inti.entities.Departement;
import fr.inti.entities.Etudiant;

public interface IEtudiantDao {
	
	
	public Etudiant ajouterEtudiant (Etudiant etudiant);
	
	public Etudiant modifierEtudiant (Etudiant etudiant);
	
	public Etudiant supprimerEtudiant (Etudiant etudiant);
	
	public Etudiant assignerDepartement (Etudiant etudiant, Departement departement);
	
	public List<Etudiant> getAllEtudiants ();
	
	public Etudiant getEtudiantById(Etudiant etudiant);

}
