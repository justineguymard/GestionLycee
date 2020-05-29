package fr.inti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="professeurs")
@SuppressWarnings("serial")
public class Professeur implements Serializable{

	// declaration des attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private int id;
	
	@Column(name="nom_p")
	private String nom;
	@Column(name="prenom_p")
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_aff")
	private Date dateAff;
	
	// transformation UML en java

	@ManyToOne
	@JoinColumn(name = "matiere_id", referencedColumnName = "id_m")
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name="departement_id" , referencedColumnName="id_d")
	private Departement departement;

	// declaration des constructeurs

	public Professeur() {
		super();
	}

	public Professeur(String nom, String prenom, Date dateAff) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateAff = dateAff;
	}

	public Professeur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	
	}
	
	

	public Professeur(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	// declaration des getters et setters
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

	public Date getDateAff() {
		return dateAff;
	}

	public void setDateAff(Date dateAff) {
		this.dateAff = dateAff;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	// redefinition de la methode toString
	@Override
	public String toString() {
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateAff=" + dateAff + "]";
	}

}
