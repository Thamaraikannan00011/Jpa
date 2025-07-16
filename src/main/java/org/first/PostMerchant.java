package org.first;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PostMerchant {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MerchantUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Merchant merchant = new Merchant();
		merchant.setName("Karan Malhotra");
		merchant.setCompanyName("GameVault Entertainment");
		merchant.setGstId("38FGHIJ3210B3UV");
		merchant.setEmail("play@gamevault.com");
		merchant.setPassword("Gaming*Vault99");
		merchant.setContact(9498765432L);
		em.persist(merchant);
		transaction.commit();
	}
}
