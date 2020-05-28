package fr.inti.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@Column(name="date_aff")
	private String dateAff;

	// transformation UML en java

	@OneToOne(mappedBy="professeur")
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name="id_dpt_professeur" , referencedColumnName="id_d")
	private Departement department;

	// declaration des constructeurs

	public Professeur() {
		super();
	}

	public Professeur(String nom, String prenom, String dateAff) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateAff = dateAff;
	}

	public Professeur(int id, String nom, String prenom, String dateAff) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateAff = dateAff;
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

	public String getDateAff() {
		return dateAff;
	}

	public void setDateAff(String dateAff) {
		this.dateAff = dateAff;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Departement getDepartment() {
		return department;
	}

	public void setDepartment(Departement department) {
		this.department = department;
	}

	// redefinition de la methode toString
	@Override
	public String toString() {
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateAff=" + dateAff + "]";
	}

}
