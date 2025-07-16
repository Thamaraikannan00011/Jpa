package org.first.task;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.first.Merchant;

public class FetchByGSTId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the GST id to fetch : ");
		String gst = sc.nextLine();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MerchantUnit");
		EntityManager em = emf.createEntityManager();
		// "fetchMerchantByGSTId" - was written in the Entity class using @NamedQuery
		Query q = em.createNamedQuery("fetchMerchatByGSTId");
		q.setParameter(1, gst);
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
