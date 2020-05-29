package fr.inti.ManagedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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

	// Association uml en java

	private IDepartementService departementService = new DepartementServiceImpl();

	public DepartementManagedBean() {
		super();
	}

	@PostConstruct
	public void init() {

		this.departement = new Departement();
		this.listeDepartements = departementService.getAllDepartements();

	}

	// getter et setter

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<Departement> getListeDepartements() {
		return listeDepartements;
	}

	public void setListeDepartements(List<Departement> listeDepartements) {
		this.listeDepartements = listeDepartements;
	}

	// methodes metier

	public String ajouterDepartement() {
		departementService.ajouterDepartement(this.departement);
		return "departementAjout";

	}

	public String modifierDepartement() {
		
		departementService.ModifierDepartement(departement);
		return "departementModifier";

	}

	public String supprimerDepartement() {
		departementService.SupprimerDepartement(this.departement);
		return "departementSupprimer";

	}
}
