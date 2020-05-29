package fr.inti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.inti.entities.Etudiant;

public class EtudiantDaoImpl implements IEtudiantDao {

	@Override
	public Etudiant ajouterEtudiant(Etudiant etudiant) {

		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager à partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();

		// ouvrir une transaction (commencer une transaction)
		tx.begin();

		// rendre l'objet persistant
		em.persist(etudiant);

		// ferme transaction
		tx.commit();

		// ferme flux
		em.close();
		emf.close();

		return etudiant;

	}

	@Override
	public Etudiant ModifierEtudiant(Etudiant etudiant) {
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager à partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();

		// ouvrir une transaction (commencer une transaction)
		tx.begin();

		// recuperer l'étudiant à modifier
		Etudiant etudiantModif = em.find(Etudiant.class, etudiant.getId());

		// Modifier l'étudiant en java
		etudiantModif.setNom(etudiant.getNom());
		etudiantModif.setPrenom(etudiant.getPrenom());

		// rendre l'objet persistant
		em.merge(etudiantModif);

		// ferme transaction
		tx.commit();

		// ferme flux
		em.close();
		emf.close();

		return etudiant;

	}

	@Override
	public int SupprimerEtudiant(Etudiant etudiant) {
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager à partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();

		// ouvrir une transaction (commencer une transaction)
		tx.begin();

		// recuperer l'étudiant à modifier
		Etudiant etudiantSuppression = em.find(Etudiant.class, etudiant.getId());

		// instauration d'une verif
		int verif = 0;

		if (etudiantSuppression != null) { // si trouvé suppresion
			// suppression
			verif++;

		} else {
		}
		
		em.remove(etudiantSuppression);

		// ferme transaction
		tx.commit();

		// ferme flux
		em.close();
		emf.close();
		
		return verif;
	}

}
