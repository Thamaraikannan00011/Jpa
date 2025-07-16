package org.first;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsingNativeQuery {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MerchantUnit");
		EntityManager em = emf.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM Merchant", Merchant.class);
		List<Merchant> li = q.getResultList();
		if(!li.isEmpty()) {
			for(Merchant m : li) {
				System.out.println(m);
			}
		}
		else {
			System.err.println("No record found");
		}
	}
}
