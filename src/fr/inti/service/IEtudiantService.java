package fr.inti.service;


import java.util.List;

import fr.inti.entities.Departement;
import fr.inti.entities.Etudiant;
import fr.inti.entities.Etudiant;

public interface IEtudiantService {
	
	public int ajouterEtudiant(Etudiant etudiant);

	public int modifierEtudiant(Etudiant etudiant);

	public int supprimerEtudiant(Etudiant etudiant);
	
	public Etudiant assignerEtudiant(Etudiant etudiant, Departement departement);
	
	public List<Etudiant> getAllEtudiants();
	
	public Etudiant getEtudiantById(Etudiant etudiant);
	

}
