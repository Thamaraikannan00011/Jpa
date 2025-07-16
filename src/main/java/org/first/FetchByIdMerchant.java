package org.first;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchByIdMerchant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Identifier to find : ");
		Integer id = sc.nextInt();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MerchantUnit");
		EntityManager em = emf.createEntityManager();
		Merchant m = em.find(Merchant.class, id);
		if(m != null) {
			System.out.println(m);
		}
		else {
			System.err.println("No record found with the id : "+id);
		}
		sc.close();
	}
}
