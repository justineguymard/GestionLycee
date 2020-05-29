package fr.inti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.inti.entities.Etudiant;
import fr.inti.entities.Matiere;
import fr.inti.entities.Professeur;

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

			// ferme flux
			em.close();
			emf.close();

			return matiere;

	}

	@Override
	public int SupprimerMatiere(Matiere matiere) {
		
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

		// instauration d'une verif
		int verif = 0;

		if (MatiereSuppression != null) { // si trouv� suppresion
			// suppression
			verif++;

		} else {
		}

		em.remove(MatiereSuppression);

		// ferme transaction
		tx.commit();

		// ferme flux
		em.close();
		emf.close();

		return verif;
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

	}
	



