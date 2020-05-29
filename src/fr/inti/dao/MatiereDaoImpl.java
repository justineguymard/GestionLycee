package fr.inti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.inti.entities.Etudiant;
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

		if (etudiantSuppression != null) { // si trouv� suppresion
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

	@Override
	public List<Matiere> getAllMatieres() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
