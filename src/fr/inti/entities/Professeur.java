package fr.inti.entities;

public class Professeur {

	// declaration des attributs
	private int id;
	private String nom;
	private String prenom;
	private String dateAff;

	// transformation UML en java

	private Matiere matiere;
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
