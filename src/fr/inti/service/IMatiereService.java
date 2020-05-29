package fr.inti.service;

import java.util.List;

import fr.inti.entities.Matiere;

public interface IMatiereService {
	
	public Matiere ajouterMatiere(Matiere matiere);

	public Matiere ModifierMatiere(Matiere matiere);

	public int SupprimerMatiere(Matiere matiere);
	
	public List<Matiere> getAllMatieres();

}
