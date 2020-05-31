package fr.inti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.inti.entities.Departement;
import fr.inti.entities.Departement;

public class DepartementDaoImpl implements IDepartementDao{

	@Override
	public Departement AjouterDepartement(Departement departement) {
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager � partir de emf
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

		// creation d'un entityManager � partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();
		try {
		// ouvrir une transaction (commencer une transaction)
		tx.begin();

		// recuperer l'�tudiant � modifier
		Departement departementModif = em.find(Departement.class, departement.getId());

		// Modifier l'�tudiant en java
		departementModif.setNom(departement.getNom());
		

		// rendre l'objet persistant
		em.merge(departementModif);

		// ferme transaction
		tx.commit();
		System.out.println("\n dans le try");
		return departementModif;
		

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
	public void SupprimerDepartement(Departement departement) {
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager � partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();

		// ouvrir une transaction (commencer une transaction)
		tx.begin();

		// recuperer l'�tudiant � modifier
		Departement departementSuppression = em.find(Departement.class, departement.getId());

	
		em.remove(departementSuppression);

		// ferme transaction
		tx.commit();

		// ferme flux
		em.close();
		emf.close();

	}

	@Override
	public List<Departement> getAllDepartements() {
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager � partir de emf
		EntityManager em = emf.createEntityManager();
		
		//requette JPQL
		String reqListeJPQL = "SELECT d FROM Departement as d";
		
		Query queryListeJPQL = em.createQuery(reqListeJPQL);
		
		@SuppressWarnings("unchecked")
		List<Departement> listeDepartementsJPQL = queryListeJPQL.getResultList();

		return listeDepartementsJPQL;
	}

	@Override
	public Departement getDepartementById(Departement departement) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// recuperer entityManager
		EntityManager em = emf.createEntityManager();
		
		//recuperer un departement par son id en utilisant les requetes nommees 

		TypedQuery queryOneDepartement=em.createNamedQuery("reqOneDepartement",Departement.class);
		
		// passage des parametres de la requete
		queryOneDepartement.setParameter("dId",departement.getId());
		// envoyer la requete et recuperer le resultat
		Departement eOneDepartement= (Departement) queryOneDepartement.getSingleResult();
		
		return eOneDepartement;
	}

}
