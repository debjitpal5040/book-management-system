package com.debjit.pal.bookmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debjit.pal.bookmanagementsystem.model.Book;
import com.debjit.pal.bookmanagementsystem.service.BookServiceImpl;

@RestController
@RequestMapping("/api/v1/")
public class BookController {


	@Autowired
	BookServiceImpl bookServiceImpl;

	// create book rest api
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bookServiceImpl.saveBook(book);
	}

	// get all books
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookServiceImpl.findAllBooks();
	}

	// get books by id
	@GetMapping("/books/{id}")
	public Book getBookUsingId(@PathVariable int id) {
		return bookServiceImpl.findBookByID(id);
	}

	// update book rest api
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
		Book book = bookServiceImpl.findBookByID(id);

		if (bookDetails.getName() != null) {
			book.setName(bookDetails.getName());
		}
		if (bookDetails.getAuthor() != null) {
			book.setAuthor(bookDetails.getAuthor());
		}
		if (bookDetails.getPublisher() != null) {
			book.setPublisher(bookDetails.getPublisher());
		}
		if (bookDetails.getPrice() != 0) {
			book.setPrice(bookDetails.getPrice());
		}

		Book updatedBook = bookServiceImpl.saveBook(book);
		return ResponseEntity.ok(updatedBook);
	}

	// delete book rest api
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable int id) {
		bookServiceImpl.deleteBookById(id);
		return ResponseEntity.ok().build();
	}

	// delete all books
	@DeleteMapping("/books")
	public ResponseEntity<Book> deleteAllBooks() {
		bookServiceImpl.deleteAllBooks();
		return ResponseEntity.ok().build();
	}
}
