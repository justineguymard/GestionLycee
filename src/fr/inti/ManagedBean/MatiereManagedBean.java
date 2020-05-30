package fr.inti.ManagedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.inti.entities.Matiere;
import fr.inti.service.IMatiereService;
import fr.inti.service.MatiereServiceImpl;


@SuppressWarnings("serial")
@ManagedBean(name = "matiereMB")
@RequestScoped
public class MatiereManagedBean implements Serializable {
	
	// attributs
		private Matiere matiere;
		private List<Matiere> listeMatieres;

		// Association uml en java

		private IMatiereService matiereService = new MatiereServiceImpl();


		public MatiereManagedBean() {
			super();
		}

		@PostConstruct
		public void init() {

			this.matiere = new Matiere();
			this.listeMatieres = matiereService.getAllMatieres();

		}

		// getter et setter

		public Matiere getMatiere() {
			return matiere;
		}

		public void setMatiere(Matiere matiere) {
			this.matiere = matiere;
		}

		public List<Matiere> getListeMatieres() {
			return listeMatieres;
		}

		public void setListeMatieres(List<Matiere> listeMatieres) {
			this.listeMatieres = listeMatieres;
		}

		// methodes metier

		public String ajouterMatiere() {
			Matiere verif = matiereService.ajouterMatiere(this.matiere);
			
			if (verif !=  null) {
				this.listeMatieres=matiereService.getAllMatieres();
				return "matiereListe";

			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Ajout impossible, veuillez réessayer"));
				return "matiereAjout";
			}

		}

		public String modifierMatiere() {
			
			Matiere verif = matiereService.ModifierMatiere(this.matiere);
			if (verif != null) {
				this.listeMatieres=matiereService.getAllMatieres();
				return "matiereListe";

			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Modification impossible, veuillez réessayer"));
				return "matiereModifier";
			}

		}

		public String supprimerMatiere() {
			int verif = matiereService.SupprimerMatiere(this.matiere);
			if (verif != 0) {
				this.listeMatieres=matiereService.getAllMatieres();
				return "matiereListe";

			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Suppression impossible, veuillez réessayer"));
				return "matiereSupprimer";
			}

		}
		
		public Matiere getMatiere(Integer id) {
			if (id == null) {
				throw new IllegalArgumentException("no id provided");
			}
			for (Matiere matiere : listeMatieres) {
				if (id.equals(matiere.getId())) {
					return matiere;
				}
			}
			return null;
		}
		
		
		
		
		
	}



