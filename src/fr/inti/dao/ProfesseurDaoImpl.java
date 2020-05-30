package fr.inti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.inti.entities.Departement;
import fr.inti.entities.Matiere;
import fr.inti.entities.Professeur;

public class ProfesseurDaoImpl implements IProfesseurDao{

	@Override
	public Professeur ajouterProfesseur(Professeur professeur) {
		//creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");
		
		//creation d'un entityManager à partir de emf
		EntityManager em = emf.createEntityManager();
		
		//creation d'un objet de type entitytransaction 
		EntityTransaction tx = em.getTransaction();
		
		//ouvrir une transaction (commencer une transaction)
		tx.begin();
		
		// rendre l'objet persistant
		
		em.persist(professeur);
		
		//fermeture de la transaction
		
		tx.commit();
		
		//fermeture des flux
		
		em.close();
		emf.close();
		
		return professeur;
	}

	@Override
	public Professeur ModifierProfesseur(Professeur professeur) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// Creation d'un entityManager a partir de emf
		EntityManager em = emf.createEntityManager();
		
		//recuperer la transaction
		EntityTransaction tx=em.getTransaction();
		try {
		//commencer une transaction
		tx.begin();
		
		//recuperer l'objet a modifier a partir de la bc par son id
		Professeur pModif=em.find(Professeur.class, professeur.getId());
		
	
		// params a modifier
		pModif.setNom(professeur.getNom());
		pModif.setPrenom(professeur.getPrenom());
		pModif.setDateAff(professeur.getDateAff());
		
		//modification de la copie de l'objet eModif dans le contexte de l'EntityManager
		
		em.merge(pModif);
		
		//commit la transaction pour envoyer concretement ces modifs à la bd
		tx.commit();
		System.out.println("\n dans le try");
		return pModif;
		

		} catch (Exception e) {
			System.err.println("Erreur de transaction");
			e.printStackTrace();
			
		} finally {
			System.out.println("\n dans le finally");

		// ferme flux
		em.close();
		emf.close();
		
		}
		System.out.println("\n dans le ret null");
		return null;
	}

	@Override
	public Professeur SupprimerProfesseur(Professeur professeur) {
		// creation de l'emf
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

				// Creation d'un entityManager a partir de emf
				EntityManager em = emf.createEntityManager();

				// recuperer un objet de type et
				EntityTransaction tx = em.getTransaction();

				// commencer le tx

				tx.begin();

				// recuperer l'objet a supprimer de la bd afin de le supprimer dans le contexte
				// de persistence

				Professeur pDel = em.find(Professeur.class,professeur.getId());

				// supprimer l'employe dans le contexte de persistence

				em.remove(pDel);
				
				//commit de la transaction
				tx.commit();
				
				//fermer les flux
				em.close();
				emf.close();
				
		return professeur;
	}

	@Override
	public List<Professeur> getAllProfesseurs() {

		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager à partir de emf
		EntityManager em = emf.createEntityManager();
		
		
		//requete JPQL
		String reqListeJPQL = "SELECT p FROM Professeur as p";
		
		Query queryListeJPQL = em.createQuery(reqListeJPQL);
		
		@SuppressWarnings("unchecked")
		List<Professeur> listeEtudiantsJPQL = queryListeJPQL.getResultList();

		return listeEtudiantsJPQL;
	}

	@Override
	public Professeur getProfesseurById(Professeur professeur) {
		
		return null;

	}

	@Override
	public Professeur AssignerDepartement(Professeur professeur, Departement departement) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// Creation d'un entityManager a partir de emf
		EntityManager em = emf.createEntityManager();
		
		//recuperer la transaction
		EntityTransaction tx=em.getTransaction();
		try {
		//commencer une transaction
		tx.begin();
		
		//recuperer l'objet a modifier a partir de la bc par son id
		Professeur pAssign=em.find(Professeur.class, professeur.getId());
		
		// params a modifier
		
		pAssign.setDepartement(departement);
		
		//modification de la copie de l'objet eModif dans le contexte de l'EntityManager
		
		em.merge(pAssign);
		
		//commit la transaction pour envoyer concretement ces modifs à la bd
		tx.commit();
		
		return pAssign;
		
	} catch (Exception e) {
		System.err.println("Erreur de transaction");
		e.printStackTrace();
		
	} finally {
		System.out.println("\n dans le finally");

	// ferme flux
	em.close();
	emf.close();
	
	}
	System.out.println("\n dans le ret null");
	return null;
	
	}

	@Override
	public Professeur AssignerMatiere(Professeur professeur, Matiere matiere) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// Creation d'un entityManager a partir de emf
		EntityManager em = emf.createEntityManager();
		
		//recuperer la transaction
		EntityTransaction tx=em.getTransaction();
		try {
		//commencer une transaction
		tx.begin();
		
		//recuperer l'objet a modifier a partir de la bc par son id
		Professeur pAssign2=em.find(Professeur.class, professeur.getId());
		
		// params a modifier
		
		pAssign2.setMatiere(matiere);
		
		//modification de la copie de l'objet eModif dans le contexte de l'EntityManager
		
		em.merge(pAssign2);
		
		//commit la transaction pour envoyer concretement ces modifs à la bd
		tx.commit();
		
return pAssign2;
		

		} catch (Exception e) {
			System.err.println("Erreur de transaction");
			e.printStackTrace();
			
		} finally {
			System.out.println("\n dans le finally");

		// ferme flux
		em.close();
		emf.close();
		
		}
		System.out.println("\n dans le ret null");
		return null;
	}
	
	

}
