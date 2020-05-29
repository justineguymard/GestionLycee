package fr.inti.service;


import fr.inti.entities.Etudiant;

public interface IEtudiantService {
	

	

	public Etudiant ajouterEtudiant(Etudiant etudiant);

	public int ModifierEtudiant(Etudiant etudiant);
	
	public Etudiant ModifierEtudiant2(Etudiant etudiant);

	public int SupprimerEtudiant(Etudiant etudiant);

}
