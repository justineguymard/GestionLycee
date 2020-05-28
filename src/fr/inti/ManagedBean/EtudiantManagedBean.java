package fr.inti.ManagedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
	
	
	//association uml en java 
	@SuppressWarnings("unused")
	private IEtudiantService etudiantService = new EtudiantServiceImpl();
	
	//Constructeur vide 
	public EtudiantManagedBean() {
		super();
	}
	
	@PostConstruct 
	public void init () {
		
		this.etudiant = new Etudiant();
		//this.listeEtudiants = etudiantService.getAllEtudiants();
		
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
	
	//méthodes métiers 
	
	public String ajouterEtudiant() {
		return null;
		
	}
	
	public String modifierEtudiant() {
		return null;
		
	}
	
	public String supprimerEtudiant() {
		return null;
		
	}
	

}
