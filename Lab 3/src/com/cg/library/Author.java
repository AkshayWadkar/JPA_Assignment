package com.cg.library;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "author_master")
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	
	private int id;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "author_id") }, inverseJoinColumns = { @JoinColumn(name = "book_id") })
	private Set<Book> books = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	/*@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", books=" + books + "]";
	}*/

	public void addBook(Book book) {
		this.getBooks().add(book);
	}

	
	
	

}
