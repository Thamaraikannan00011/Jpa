package org.first;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMerchant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Identifier to update : ");
		Integer id = sc.nextInt();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MerchantUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		Merchant merchant = em.find(Merchant.class, id);
		if(merchant != null) {
			tran.begin();
			merchant.setName("Ashok Tiwari");
			merchant.setCompanyName("Paper & Pen Station");
			merchant.setGstId("34IJKLM8765H9GH");
			merchant.setEmail("supplies@paperpen.com");
			merchant.setPassword("Stationery#Office24");
			merchant.setContact(8183216547L);
			tran.commit();
		}
		else {
			System.err.println("No record found with the id : "+id);
		}
		sc.close();
	}
}
