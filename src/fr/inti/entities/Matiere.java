package fr.inti.entities;

public class Matiere {
	
	private int id;
	private String intitule;
	
	// transformation UML en java 
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
