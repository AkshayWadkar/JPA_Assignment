package com.cg.author.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();		
		EntityTransaction transaction = em.getTransaction();
		

		/*Author auth = new Author();
		
		auth.setFirstName("Akshay");
		auth.setMiddleName("Chandrakant");
		auth.setLastName("Wadkar");
		auth.setPhoneNo(9920);
		transaction.begin();
		em.persist(auth);
		transaction.commit();
		System.out.println("Added author to database.");*/
		
		/*int id = 2;
		Author auth = em.find(Author.class, id);
		auth.setFirstName("Akash");
		transaction.begin();
		em.merge(auth);
		transaction.commit();
		System.out.println("updated author");*/
		
		/*int id = 9;
		Author auth = em.find(Author.class, id);
		transaction.begin();
		em.remove(auth);
		transaction.commit();
		System.out.println("deleted author");*/
		
		
		int id;
		Author auth = new Author();
		transaction.begin();
		em.find(Author.class, id =8);
		transaction.commit();
		System.out.println("find author");
		
		em.close();
		factory.close();
	}
}
