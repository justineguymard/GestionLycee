package fr.inti.service;


import java.util.List;

import fr.inti.entities.Departement;
import fr.inti.entities.Etudiant;

public interface IEtudiantService {
	
	public Etudiant ajouterEtudiant(Etudiant etudiant);

	public int ModifierEtudiant(Etudiant etudiant);

	public int SupprimerEtudiant(Etudiant etudiant);
	
	public Etudiant AssignerEtudiant(Etudiant etudiant, Departement departement);
	
	public List<Etudiant> getAllEtudiants();

}
