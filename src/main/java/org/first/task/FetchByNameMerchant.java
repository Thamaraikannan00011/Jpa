package org.first.task;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.first.Merchant;

public class FetchByNameMerchant {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name to find : ");
		String nm = sc.nextLine();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MerchantUnit");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT m FROM Merchant m WHERE m.name = ?1");
		q.setParameter(1, nm);
		List<Merchant> li = q.getResultList();
		if(li != null) {
			for(Merchant m : li) {
				System.out.println(m);
			}
		}
		else {
			System.err.println("No record found with the name : "+nm);
		}
		sc.close();
	}
}
