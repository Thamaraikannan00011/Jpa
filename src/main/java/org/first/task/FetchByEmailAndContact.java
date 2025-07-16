package org.first.task;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.first.Merchant;

public class FetchByEmailAndContact {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email to fetch : ");
		String email = sc.nextLine();
		System.out.println("Enter the contact : ");
		Long con = sc.nextLong();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MerchantUnit");
		EntityManager em = emf.createEntityManager();
		// "fetchMerchantByEmailAndContact" - was written in the Entity class using @NamedQuery
		Query q = em.createNamedQuery("fetchMerchantByEmailAndContact");
		q.setParameter(1, email);
		q.setParameter(2, con);
		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println(m);
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
	}
}
//id = 10,
//name = Karan Malhotra,
//companyName = GameVault Entertainment,
//gstId = 38FGHIJ3210B3UV,
//email = play@gamevault.com,
//password = Gaming*Vault99,
//contact = 9498765432
