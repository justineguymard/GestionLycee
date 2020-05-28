package fr.inti.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="matieres")
@SuppressWarnings("serial")
public class Matiere implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_m")
	private int id;
	
	@Column(name="intitule_m")
	private String intitule;
	
	// transformation UML en java 
	@OneToOne 
	@JoinColumn(name="id_professeur", referencedColumnName="id_p")
	private Professeur professeur;

	//declaration des constructeurs 
	
	public Matiere() {
		super();
	}

	public Matiere(String intitule) {
		super();
		this.intitule = intitule;
	}

	public Matiere(int id, String intitule) {
		super();
		this.id = id;
		this.intitule = intitule;
	}

	// declaration des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	// redefinition de la methode toString
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", intitule=" + intitule + "]";
	}
	
	

}
