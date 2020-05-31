package fr.inti.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.inti.entities.Departement;
import fr.inti.entities.Matiere;
import fr.inti.entities.Professeur;
import fr.inti.service.IProfesseurService;
import fr.inti.service.ProfesseurServiceImpl;

@SuppressWarnings("serial")
@ManagedBean(name = "professeurMB")
@RequestScoped
public class ProfesseurManagedBean implements Serializable {

	// attributs
	private Professeur professeur;
	private List<Professeur> listeProfesseurs;
	private Departement departement;
	private Matiere matiere;
private boolean indice;

	// association uml en java

	IProfesseurService professeurService = new ProfesseurServiceImpl();

	// constructeur vide
	public ProfesseurManagedBean() {
		super();
	}

	@PostConstruct
	public void init() {

		this.professeur = new Professeur();
		this.listeProfesseurs = professeurService.getAllProfesseurs();
		this.departement = new Departement();
		this.matiere = new Matiere();
		this.indice = false;
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

	public boolean isIndice() {
		return indice;
	}

	public void setIndice(boolean indice) {
		this.indice = indice;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	// methodes metiers
	public String ajouterProfesseur() {
		Professeur verif = professeurService.ajouterProfesseur(this.professeur);
		if (verif != null) {
			this.listeProfesseurs = professeurService.getAllProfesseurs();
			return "professeurListe";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Ajout impossible, veuillez réessayer"));
			return "professeurAjout";
		}

	}

	public String modifierProfesseur() {

		Professeur verif = professeurService.ModifierProfesseur(this.professeur);

		if (verif != null) {
			this.listeProfesseurs = professeurService.getAllProfesseurs();
			return "professeurListe";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Modification impossible, veuillez réessayer"));
			return "professeurModifier";
		}

	}

	public String supprimerProfesseur() {
		Professeur verif = professeurService.SupprimerProfesseur(this.professeur);
		if (verif != null) {
			this.listeProfesseurs = professeurService.getAllProfesseurs();
			return "professeurListe";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Suppression impossible, veuillez réessayer"));
			return "professeurSupprimer";
		}
	}

	public String assignerDepartement() {

		Professeur verif = professeurService.AssignerDepartement(this.professeur, this.departement);

		if (verif != null) {
			this.listeProfesseurs = professeurService.getAllProfesseurs();
			return "professeurListe";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Assignation impossible, veuillez réessayer"));
			return "professeurAssignerDepartement";
		}
	}

	public String assignerMatiere() {


		Professeur verif = professeurService.AssignerMatiere(this.professeur, this.matiere);

		if (verif != null) {
			this.listeProfesseurs = professeurService.getAllProfesseurs();
			return "professeurListe";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Assignation impossible, veuillez réessayer"));
			return "professeurAssignerMatiere";
		}
	}

	public Professeur getProfesseur(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("no id provided");
		}
		for (Professeur professeur : listeProfesseurs) {
			if (id.equals(professeur.getId())) {
				return professeur;
			}
		}
		return null;
	}

	public List<Professeur> getProfSansMatiere() {
		List <Professeur> listeProfSansMatiere = new ArrayList<Professeur>();
		for (Professeur professeur : this.listeProfesseurs) {
			if (professeur.getMatiere() == null ) {
				listeProfSansMatiere.add(professeur);
			}
		}
		return listeProfSansMatiere;
	

	}

	public List<Professeur> getProfSansDpt() {
		List <Professeur> listeProfSansDpt = new ArrayList<Professeur>();
		for (Professeur professeur : this.listeProfesseurs) {
			if (professeur.getDepartement() == null ) {
				listeProfSansDpt.add(professeur);
			}
		}
		return listeProfSansDpt;
	

	}
	
 public String Rechercher() {
	 
	 Professeur verif = professeurService.getProfesseurById(this.professeur);
	 List<Professeur> testListe = new ArrayList<Professeur>();
		if (verif != null) {
			this.indice =true;
			System.out.println(verif);
			testListe.add(verif);
			this.listeProfesseurs=testListe;
			return "professeurRechercher";

		} else {
			this.indice =false; 
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Recherche impossible, identifiant invalide"));
			return "professeurRechercher";
		}

 }
	

}