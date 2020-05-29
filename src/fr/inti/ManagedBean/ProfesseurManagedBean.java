package fr.inti.ManagedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.inti.entities.Departement;
import fr.inti.entities.Etudiant;
import fr.inti.entities.Professeur;
import fr.inti.service.IProfesseurService;
import fr.inti.service.ProfesseurServiceImpl;

@SuppressWarnings("serial")
@ManagedBean(name="professeurMB")
@RequestScoped
public class ProfesseurManagedBean implements Serializable {

	// attributs 
	private Professeur professeur;
	private List<Professeur> listeProfesseurs;
	private Departement departement;
	//association uml en java
	
	IProfesseurService professeurService= new ProfesseurServiceImpl();

	//constructeur vide
	public ProfesseurManagedBean() {
		super();
	}
	
	@PostConstruct 
	public void init () {
		
		this.professeur = new 	Professeur();
		this.listeProfesseurs = professeurService.getAllProfesseurs();
		this.departement= new Departement();
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public List<Professeur> getListeProfesseurs() {
		return listeProfesseurs;
	}

	public void setListeProfesseurs(List<Professeur> listeProfesseurs) {
		this.listeProfesseurs = listeProfesseurs;
	}
	
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	
	// methodes metiers 
	
	public String ajouterProfesseur() {
		professeurService.ajouterProfesseur(this.professeur);
		return "professeurs";
		
	}

	public String modifierProfesseur() {
		
		professeurService.ModifierProfesseur(professeur);
		return "professeurs";
	
}
	
	public String supprimerProfesseur() {
		
		professeurService.SupprimerProfesseur(professeur);
		return "professeurs";
}
	
	
	public String assignerDepartement() {
		
		professeurService.AssignerDepartement(this.professeur, this.departement);
		return "professeurs";
}
}