package fr.inti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import fr.inti.entities.Etudiant;

public class CreateTest {

	public static void main(String[] args) {
		//creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");
		
		//creation d'un entityManager à partir de emf
		EntityManager em = emf.createEntityManager();
		
		//creation d'un objet de type entitytransaction 
		EntityTransaction tx = em.getTransaction();
		
		//ouvrir une transaction (commencer une transaction)
		tx.begin();
		
		//instancier les objets dan la bd 
		Etudiant e1=new Etudiant("TOTO","Titi");
		//Etudiant e2=new Etudiant("FOFO","Fifi");
		//Etudiant e3=new Etudiant("YOYO","Yiyi");
	

		//rendre les objets persistents (lier ces objets au context)
		em.persist(e1);
		//em.persist(e2);
		//em.persist(e3);
		
		System.out.println(e1);
		tx.commit(); //em.gettransaction.commit
		
		em.close();
		emf.close();
		
	}

}
