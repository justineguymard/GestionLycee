package fr.inti.dao;

import fr.inti.entities.Etudiant;

public interface IEtudiantDao {
	
	
	public Etudiant ajouterEtudiant (Etudiant etudiant);
	
	public int ModifierEtudiant (Etudiant etudiant);
	
	public int SupprimerEtudiant (Etudiant etudiant);

}
