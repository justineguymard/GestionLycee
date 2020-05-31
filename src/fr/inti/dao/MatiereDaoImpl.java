package fr.inti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.inti.entities.Departement;
import fr.inti.entities.Matiere;


public class MatiereDaoImpl implements IMatiereDao{

	@Override
	public Matiere AjouterMatiere(Matiere matiere) {
		
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager � partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();

		// ouvrir une transaction (commencer une transaction)
		tx.begin();

		// rendre l'objet persistant
		em.persist(matiere);

		// ferme transaction
		tx.commit();

		// ferme flux
		em.close();
		emf.close();
		
		return matiere;
	}

	@Override
	public Matiere ModifierMatiere(Matiere matiere) {
		
			// creation d'un entityManagerFactory
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

			// creation d'un entityManager � partir de emf
			EntityManager em = emf.createEntityManager();

			// creation d'un objet de type entitytransaction
			EntityTransaction tx = em.getTransaction();
			try {
			// ouvrir une transaction (commencer une transaction)
			tx.begin();

			// recuperer l'�tudiant � modifier
			Matiere MatiereModif = em.find(Matiere.class, matiere.getId());

			// Modifier l'�tudiant en java
			MatiereModif.setIntitule(matiere.getIntitule());
			

			// rendre l'objet persistant
			em.merge(MatiereModif);

			// ferme transaction
			tx.commit();
			System.out.println("\n dans le try");
			return MatiereModif;
			

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
	public void SupprimerMatiere(Matiere matiere) {
		
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager � partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();

		// ouvrir une transaction (commencer une transaction)
		tx.begin();

		// recuperer l'�tudiant � modifier
		Matiere MatiereSuppression = em.find(Matiere.class, matiere.getId());

		
		em.remove(MatiereSuppression);

		// ferme transaction
		tx.commit();

		// ferme flux
		em.close();
		emf.close();

		
	}

	@Override
	public List<Matiere> getAllMatieres() {
		
		// creation d'un entityManagerFactory
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

				// creation d'un entityManager � partir de emf
				EntityManager em = emf.createEntityManager();
				
				
				//requete JPQL
				String reqListeJPQL = "SELECT m FROM Matiere as m";
				
				Query queryListeJPQL = em.createQuery(reqListeJPQL);
				
				@SuppressWarnings("unchecked")
				List<Matiere> listeMatieresJPQL = queryListeJPQL.getResultList();

				return listeMatieresJPQL;
			}

	@Override
	public Matiere getMatiereById(Matiere matiere) {
	
		// recuperer l'entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// recuperer entityManager
		EntityManager em = emf.createEntityManager();
		
		//recuperer un matiere par son id en utilisant les requetes nommees 

		TypedQuery queryOneMatiere=em.createNamedQuery("reqOneMatiere",Matiere.class);
		
		// passage des parametres de la requete
		queryOneMatiere.setParameter("mId",matiere.getId());
		// envoyer la requete et recuperer le resultat
		Matiere eOneMatiere= (Matiere) queryOneMatiere.getSingleResult();
		
		return eOneMatiere;
	
	}

	}
	



