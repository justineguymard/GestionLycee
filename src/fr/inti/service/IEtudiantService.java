package fr.inti.service;


import fr.inti.entities.Etudiant;

public interface IEtudiantService {
	

	

	public Etudiant ajouterEtudiant(Etudiant etudiant);

	public int ModifierEtudiant();

	public int SupprimerEtudiant();

}
