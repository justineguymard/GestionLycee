package fr.inti.entities;

public class Etudiant {
	
	//attributs
	private int id;	
	private String nom;
	private String prenom;

		
	//transformation de l'association UML en 
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

	//to
	
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", departement=" + departement + "]";
	}
	
	
	
	
	
	
	
	

}
