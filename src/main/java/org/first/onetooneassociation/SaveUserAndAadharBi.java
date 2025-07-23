package org.first.onetooneassociation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUserAndAadharBi {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOneUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();
		
		UserBi u = new UserBi();
		AadharBi card = new AadharBi();
		
		u.setName("Raju");
		u.setPhone(9988776655l);
		
		card.setNumber(666677778888l);
		card.setAddress("DPI");
		
		card.setUserbi(u);
		u.setCard(card);
		
		em.persist(u);
		tran.commit();
	}

}
