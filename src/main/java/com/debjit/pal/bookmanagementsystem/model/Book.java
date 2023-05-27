package com.debjit.pal.bookmanagementsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	@NotNull(message = "Name is mandatory")
	private String name;

	@Column(name = "author")
	@NotNull(message = "Author is mandatory")
	private String author;

	@Column(name = "publisher")
	@NotNull(message = "Publisher is mandatory")
	private String publisher;

	@Column(name = "isbn", unique = true, length = 13, nullable = false)
	private String isbn;

	// No-arg constructor
	public Book() {
		super();
	}

	// Parameterized constructor
	public Book(String name, String author, String publisher, String isbn) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
	}

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getisbn() {
		return isbn;
	}

	public void setisbn(String isbn) {
		this.isbn = isbn;
	}
}
