package fr.inti.dao;

import java.util.List;

import fr.inti.entities.Matiere;

public interface IMatiereDao {
	
public Matiere AjouterMatiere(Matiere matiere);
	
	public Matiere ModifierMatiere (Matiere matiere);
	
	public int SupprimerMatiere(Matiere matiere);

	public List<Matiere> getAllMatieres ();
}
