package fr.inti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.inti.entities.Departement;

public class DepartementDaoImpl implements IDepartementDao{

	@Override
	public Departement AjouterDepartement(Departement departement) {
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager à partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();

		// ouvrir une transaction (commencer une transaction)
		tx.begin();

		// rendre l'objet persistant
		em.persist(departement);

		// ferme transaction
		tx.commit();

		// ferme flux
		em.close();
		emf.close();

		return departement;
	}

	@Override
	public Departement ModifierDepartement(Departement departement) {
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager à partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();

		// ouvrir une transaction (commencer une transaction)
		tx.begin();

		// recuperer l'étudiant à modifier
		Departement departementModif = em.find(Departement.class, departement.getId());

		// Modifier l'étudiant en java
		departementModif.setNom(departement.getNom());
		

		// rendre l'objet persistant
		em.merge(departementModif);

		// ferme transaction
		tx.commit();

		// ferme flux
		em.close();
		emf.close();

		return departement;
	}

	@Override
	public int SupprimerDepartement(Departement departement) {
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager à partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();

		// ouvrir une transaction (commencer une transaction)
		tx.begin();

		// recuperer l'étudiant à modifier
		Departement departementSuppression = em.find(Departement.class, departement.getId());

		// instauration d'une verif
		int verif = 0;

		if (departementSuppression != null) { // si trouvé suppresion
			// suppression
			verif++;

		} else {
		}

		em.remove(departementSuppression);

		// ferme transaction
		tx.commit();

		// ferme flux
		em.close();
		emf.close();

		return verif;
	}

	@Override
	public List<Departement> getAllDepartements() {
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager à partir de emf
		EntityManager em = emf.createEntityManager();
		
		//requette JPQL
		String reqListeJPQL = "SELECT d FROM Departement as d";
		
		Query queryListeJPQL = em.createQuery(reqListeJPQL);
		
		@SuppressWarnings("unchecked")
		List<Departement> listeDepartementsJPQL = queryListeJPQL.getResultList();

		return listeDepartementsJPQL;
	}

}
