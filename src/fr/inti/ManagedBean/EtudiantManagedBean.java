package fr.inti.ManagedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.inti.entities.Departement;
import fr.inti.entities.Etudiant;
import fr.inti.service.EtudiantServiceImpl;
import fr.inti.service.IEtudiantService;

@SuppressWarnings("serial")
@ManagedBean(name="etudiantMB")
@RequestScoped
public class EtudiantManagedBean implements Serializable {
	
	//attributs 
	private Etudiant etudiant;
	private List <Etudiant> listeEtudiants;
	private Departement  departement;
	//association uml en java 
	
	private IEtudiantService etudiantService = new EtudiantServiceImpl();
	
	//Constructeur vide 
	public EtudiantManagedBean() {
		super();
	}
	
	@PostConstruct 
	public void init () {
		
		this.etudiant = new Etudiant();
		this.departement= new Departement();
		this.listeEtudiants = etudiantService.getAllEtudiants();
		
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public List<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}
	
		public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	
	//méthodes métiers 
	

	public String ajouterEtudiant() {
		etudiantService.ajouterEtudiant(this.etudiant);
		return "etudiantAjout";
		
		
	}
	
	public String modifierEtudiant() {
		int verif = etudiantService.ModifierEtudiant(this.etudiant);
		if (verif != 0 ) {
		return "etudiantModifier";
		} else {
			return "accueil";
		}
		
	}
	

	
	public String supprimerEtudiant() {
		etudiantService.SupprimerEtudiant(this.etudiant);
		return  "etudiantSupprimer";
		
	}
	
	
	public String assignerDepartement() {
		etudiantService.AssignerEtudiant(this.etudiant, this.departement );
		return "etudiantAssignerDepartement";
	}

}
