package fr.inti.ManagedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.inti.entities.Matiere;
import fr.inti.service.IMatiereService;
import fr.inti.service.MatiereServiceImpl;

@SuppressWarnings("serial")
@ManagedBean(name = "matiereMB")
@RequestScoped
public class MatiereManagedBean {
	
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
			matiereService.ajouterMatiere(this.matiere);
			return "matiereAjout";

		}

		public String modifierMatiere() {
			
			matiereService.ModifierMatiere(matiere);
			return "matiereModifier";

		}

		public String supprimerMatiere() {
			matiereService.SupprimerMatiere(this.matiere);
			return "matiereSupprimer";

		}
	}



