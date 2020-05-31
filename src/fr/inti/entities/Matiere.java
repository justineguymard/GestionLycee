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
@Table(name = "matieres")
@SuppressWarnings("serial")
@NamedQuery(name= "reqOneMatiere", query = "SELECT m FROM Matiere m WHERE m.id=:mId")
public class Matiere implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_m")
	private int id;

	@Column(name = "intitule_m")
	private String intitule;

	// transformation UML en java
	@OneToMany(mappedBy="matiere")
	private List<Professeur> professeurs;

	// declaration des constructeurs

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

	public List<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	// redefinition de la methode toString
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", intitule=" + intitule + "]";
	}

}
