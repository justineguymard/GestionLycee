package fr.inti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professeur SupprimerProfesseur(Professeur professeur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professeur> getAllProfesseurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professeur getProfesseurById(Professeur professeur) {
		// TODO Auto-generated method stub
		return null;
	}

}
