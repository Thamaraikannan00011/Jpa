package org.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestConfig {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MerchantUnit");
		EntityManager em = emf.createEntityManager();
		System.out.println(em);
	}
}
