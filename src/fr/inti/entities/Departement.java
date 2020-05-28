package fr.inti.entities;

import java.util.List;

public class Departement {
	
	private int id;
	private String nom; 

	private List<Etudiant> listeEtudiants;
	
	
	//constructeurs 
	public Departement() {
		super();
	}

	public Departement(String nom) {
		super();
		this.nom = nom;
	}

	public Departement(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	
	//getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
}
