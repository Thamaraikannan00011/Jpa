package org.first.task;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TaskPhoneAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MerchantUnit");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT m FROM Merchant m WHERE m.contact = ?1 AND m.password = ?2");
		System.out.println("Enter the phone number : ");
		long ph = sc.nextLong();
		System.out.println("Enter the password : ");
		String pw = sc.next();
		q.setParameter(1, ph);//9498765432
		q.setParameter(2, pw);//Gaming*Vault99
		
		try {
			q.getSingleResult();
			System.out.println("Merchant verifed ...");
		} catch (NoResultException e) {
			System.err.println("No result found ...");
		}
		finally {
			sc.close();
		}
	}
}
