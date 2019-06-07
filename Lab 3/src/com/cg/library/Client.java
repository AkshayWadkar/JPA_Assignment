package com.cg.library;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Client {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		// first define few books

		Book bk = new Book();
		bk.setISBN(1);
		bk.setTitle("jantar");
		bk.setPrice(20);

		Book bk1 = new Book();
		bk1.setISBN(2);
		bk1.setTitle("mantar");
		bk1.setPrice(25);

		Book bk2 = new Book();
		bk2.setISBN(3);
		bk2.setTitle("tanatr");
		bk2.setPrice(30);

		// now define first order and add few products in it
		Author auth = new Author();
		auth.setId(101);
		auth.setName("Akshay");

		auth.addBook(bk);
		auth.addBook(bk1);
		auth.addBook(bk2);

		// now define second order and add few products in it
		Author auth2 = new Author();
		auth2.setId(102);
		auth2.setName("Akash");

		auth2.addBook(bk);
		auth2.addBook(bk1);
		auth2.addBook(bk2);

		// save orders using entity manager

		em.persist(auth);
		em.persist(auth2);

		System.out.println("Added books along with author details to database.");

		// to get all books in database

		/*String qry = "SELECT book FROM Book book";
		TypedQuery<Book> book1 = em.createQuery(qry, Book.class);
		List<Book> listBook = book1.getResultList();
		for (Book ele : listBook)
			System.out.println(ele.toString());*/

		transaction.commit();
		em.close();
		factory.close();
	}
}
