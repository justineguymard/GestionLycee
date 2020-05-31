package fr.inti.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="departements")
@SuppressWarnings("serial")
@NamedQuery(name= "reqOneDepartement", query = "SELECT d FROM Departement d WHERE d.id=:dId")
public class Departement implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_d")
	private int id;
	@Column(name="nom_d")
	private String nom; 

	@OneToMany(mappedBy="departement")
	private List<Etudiant> listeEtudiants;
	
	@OneToMany(mappedBy="departement")
	private List <Professeur> listeProfesseurs;
	
	
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
	
	

	public List<Professeur> getListeProfesseurs() {
		return listeProfesseurs;
	}

	public void setListeProfesseurs(List<Professeur> listeProfesseurs) {
		this.listeProfesseurs = listeProfesseurs;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
}
