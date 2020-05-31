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

import fr.inti.service.IDepartementService;
import fr.inti.service.DepartementServiceImpl;

@SuppressWarnings("serial")
@ManagedBean(name = "departementMB")
@RequestScoped
public class DepartementManagedBean implements Serializable {

	// attributs
	private Departement departement;
	private List<Departement> listeDepartements;
	private boolean indice;

	// Association uml en java

	private IDepartementService departementService = new DepartementServiceImpl();

	public DepartementManagedBean() {
		super();
	}

	@PostConstruct
	public void init() {

		this.departement = new Departement();
		this.listeDepartements = departementService.getAllDepartements();
		this.indice = false;

	}

	// getter et setter

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

	public List<Departement> getListeDepartements() {
		return listeDepartements;
	}

	public void setListeDepartements(List<Departement> listeDepartements) {
		this.listeDepartements = listeDepartements;
	}

	// methodes metier

	public String ajouterDepartement() {
		Departement verif = departementService.ajouterDepartement(this.departement);
		if (verif != null) {
			this.listeDepartements = departementService.getAllDepartements();
			return "departementListe";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Ajout impossible, veuillez réessayer"));
			return "departementAjout";
		}
		

	}

	public String modifierDepartement() {
		Departement verif = departementService.ModifierDepartement(departement);
		if (verif != null) {
			this.listeDepartements = departementService.getAllDepartements();
			return "departementListe";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Modification impossible, veuillez réessayer"));
			return "departementModifier";
		}
	}

	public String supprimerDepartement() {
		int verif = departementService.SupprimerDepartement(this.departement);
		if (verif != 0) {
			this.listeDepartements = departementService.getAllDepartements();
			return "departementListe";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Suppression impossible, veuillez réessayer"));
			return "departementSupprimer";
		}
	}
	
	
	
	public Departement getDepartement(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("no id provided");
		}
		for (Departement departement : listeDepartements) {
			if (id.equals(departement.getId())) {
				return departement;
			}
		}
		return null;
	}
	
	 public String Rechercher() {
		 
		 Departement verif = departementService.getDepartementById(this.departement);
		 List <Departement> testListe = new ArrayList<Departement>();
			if (verif != null) {
				this.indice = true;
				System.out.println(verif);
				
				testListe.add(verif);
				this.listeDepartements = testListe;
				return "departementRechercher";

			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Recherche impossible, identifiant invalide"));
				return "departementRechercher";
			}
	 }
}
