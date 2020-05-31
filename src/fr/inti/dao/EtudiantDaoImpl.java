package fr.inti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import fr.inti.entities.Departement;
import fr.inti.entities.Etudiant;


public class EtudiantDaoImpl implements IEtudiantDao {

	@Override
	public Etudiant ajouterEtudiant(Etudiant etudiant) {

		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager � partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();

		try {
		// ouvrir une transaction (commencer une transaction)
		tx.begin();
		
		System.out.println(etudiant);;
		
		// recuperer l'�tudiant � modifier
//		Etudiant etudiantModif = em.find(Etudiant.class, etudiant.getId());
//
//		// Modifier l'�tudiant en java
//		etudiantModif.setNom(etudiant.getNom());
//		etudiantModif.setPrenom(etudiant.getPrenom());
		// rendre l'objet persistant
		em.persist(etudiant);
		// ferme transaction
		tx.commit();
	
		return etudiant;
		
		} catch (Exception e) {
			System.err.println("Erreur de transaction");
			e.printStackTrace();
			
		} finally {
		

		// ferme flux
		em.close();
		emf.close();
		
		}
		
		return null;

	}

	@Override
	public Etudiant modifierEtudiant(Etudiant etudiant) {
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
		Etudiant etudiantModif = em.find(Etudiant.class, etudiant.getId());

		// Modifier l'�tudiant en java
		etudiantModif.setNom(etudiant.getNom());
		etudiantModif.setPrenom(etudiant.getPrenom());

		// rendre l'objet persistant
		em.merge(etudiantModif);
		// ferme transaction
		tx.commit();
		System.out.println("\n dans le try");
		return etudiantModif;
		

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
	public Etudiant supprimerEtudiant(Etudiant etudiant) {
		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager � partir de emf
		EntityManager em = emf.createEntityManager();

		// creation d'un objet de type entitytransaction
		EntityTransaction tx = em.getTransaction();
		
		
		// ouvrir une transaction (commencer une transaction)
		tx.begin();

		// recuperer l'�tudiant � modifier
		Etudiant etudiantSuppression = em.find(Etudiant.class, etudiant.getId());
		
		em.remove(etudiantSuppression);

		// ferme transaction
		tx.commit();
		System.out.println(etudiantSuppression);
		
		// ferme flux
		em.close();
		emf.close();
		
		return etudiantSuppression;
		
	}

	@Override
	public Etudiant assignerDepartement(Etudiant etudiant, Departement departement) {
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
		Etudiant etudiantModif = em.find(Etudiant.class, etudiant.getId());
		////Departement deptModif = em.find(Departement.class, depatement.getId());

		// Modifier l'�tudiant en java

		etudiantModif.setDepartement(departement);

		// rendre l'objet persistant
		em.merge(etudiantModif);

		// ferme transaction
		tx.commit();

		return etudiantModif;
		

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
		public List<Etudiant> getAllEtudiants() {

		// creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

		// creation d'un entityManager � partir de emf
		EntityManager em = emf.createEntityManager();
		
		//requette JPQL
		String reqListeJPQL = "SELECT e FROM Etudiant as e";
		
		Query queryListeJPQL = em.createQuery(reqListeJPQL);
		
		@SuppressWarnings("unchecked")
		List<Etudiant> listeEtudiantsJPQL = queryListeJPQL.getResultList();

		return listeEtudiantsJPQL;
	}

	
		@Override
		public Etudiant getEtudiantById(Etudiant etudiant) {
			
			// recuperer l'entityManagerFactory
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");

			// recuperer entityManager
			EntityManager em = emf.createEntityManager();
			System.err.println(etudiant.getId());
			Etudiant eOut = em.find(Etudiant.class, etudiant.getId()) ;
			
			System.out.println(eOut);
			
			em.close();
			emf.close();
			
			return eOut;
		}

}
