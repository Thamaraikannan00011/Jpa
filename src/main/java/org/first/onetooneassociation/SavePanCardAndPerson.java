package org.first.onetooneassociation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePanCardAndPerson {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOneUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		PersonUni per = new PersonUni();
		per.setName("Kannan");
		per.setPhone(8888776655l);
		
		PanCardUni card = new PanCardUni();
		card.setNumber("EFGH5678");
		card.setPincode(556666);
		per.setCard(card);
		
		em.persist(per);
//		em.persist(card); // if we are using cascade in the "association mapping annotation" no need to externally save the child entity
		
		et.commit();
	}
}
