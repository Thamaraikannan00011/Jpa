package org.first;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAllMerchant {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MerchantUnit");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT m FROM Merchant m");
		List<Merchant> li = q.getResultList();
		if(li != null) {
			for(Merchant m : li) {
				System.out.println(m);
			}
		}
		else {
			System.err.println("No record found");
		}
	}
}
