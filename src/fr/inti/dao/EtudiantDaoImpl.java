package fr.inti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import fr.inti.entities.Etudiant;

public class EtudiantDaoImpl implements IEtudiantDao {

	@Override
	public void ajouterEtudiant(Etudiant etudiant) {
		
		//creation d'un entityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("puGestionLycee");
		
		//creation d'un entityManager à partir de emf
		EntityManager em = emf.createEntityManager();
		
		//creation d'un objet de type entitytransaction 
		EntityTransaction tx = em.getTransaction();
		
		//ouvrir une transaction (commencer une transaction)
		tx.begin();
		
		//Instancier l'objet venant du formulaire
		Etudiant e1 = new Etudiant(etudiant.getNom(), etudiant.getPrenom());
		
		//rendre l'objet persistant
		em.persist(e1);
		
		//ferme transaction
		tx.commit();
		
		//ferme flux
		em.close();
		emf.close();

		 
	}

	@Override
	public int ModifierEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int SupprimerEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		return 0;
	}

}
