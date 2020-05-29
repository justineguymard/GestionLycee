package fr.inti.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="etudiants")
public class Etudiant implements Serializable {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_e")
	private int id;	
	@Column(name="nom_e")
	private String nom;
	@Column(name="prenom_e")
	private String prenom;

		
	//transformation de l'association UML en 
	@ManyToOne
	@JoinColumn(name="departement_id", referencedColumnName="id_d" )
	private Departement departement;
	
	//Constructeur 
		public Etudiant() {
		super();
	}


	public Etudiant(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}


	public Etudiant(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	
	//getters setters
	
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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

// redefinition du toString
	@Override
	public String toString() {
		return "#" + id + ", " + nom + ", " + prenom + "";
	}

	
	

	
	
	
	
	
	
	

}
