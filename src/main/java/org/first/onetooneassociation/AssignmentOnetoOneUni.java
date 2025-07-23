package org.first.onetooneassociation;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

class IdNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public IdNotFoundException(String message) {
		super(message);
	}
}

public class AssignmentOnetoOneUni {
	
	// find person by the id
	
	public static void findById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOneUnit");
		EntityManager em = emf.createEntityManager();
		PersonUni p = em.find(PersonUni.class, id);
		if(p != null) {
			System.out.println("================= Find Person By Id ========================");
			System.out.println(p);
			System.out.println("============================================================");
		}
		else {
			throw new IdNotFoundException("Given id doesn't match");
		}
	}
	
	// find person by name
	
	public static void findByName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOneUnit");
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("findByName");
		q.setParameter(1, name);
		@SuppressWarnings("unchecked")
		List<PersonUni> li = q.getResultList();
		if(li != null) {
			System.out.println("================= Find Person By Name ======================");
			for(PersonUni p : li) {
				System.out.println(p);
				System.out.println("============================================================");
			}
		}
		else {
			throw new IdNotFoundException("Given name doesn't match");
		}
	}
	
	// find person by phone number
	public static void findByPhone(long phone) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOneUnit");
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("findByPhone");
		q.setParameter(1, phone);
		try {
			PersonUni p = (PersonUni) q.getSingleResult();
			System.out.println("=============== Find Person by phone ====================");
			System.out.println(p);
			System.out.println("=========================================================");
		} catch (NoResultException e) {
			System.err.println("No record found by the phone");
		}
		
	}
	
	// find pan card details by person id
	public static void findPancardByPersonId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OneToOneUnit");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT p.card FROM PersonUni p WHERE p.id = ?1");
		q.setParameter(1, id);
		try {
			PanCardUni p = (PanCardUni) q.getSingleResult();
			System.out.println("=============== Find Pancard by Person id ================");
			System.out.println(p);
			System.out.println("==========================================================");
		} catch (NoResultException e) {
			System.err.println("No Pancard record found by the Person id");
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// find the person by Id
		System.out.println("Enter the identifier of person to fetch : ");
		int id = sc.nextInt();
		findById(id);
		
		// find the person by name
		System.out.println("Enter the name of person to find : ");
		String name = sc.next();
		findByName(name);
		
		// find the person by phone
		System.out.println("Enter the phone no to fetch : ");
		long phone = sc.nextLong();
		findByPhone(phone);
		
		// find pan card info by person id
		System.out.println("Enter the person id to fetch pancard : ");
		int pid = sc.nextInt();
		findPancardByPersonId(pid);
		
		sc.close();
	}
}
