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
import com.debjit.pal.bookmanagementsystem.repository.BookRepository;
import com.debjit.pal.bookmanagementsystem.service.BookServiceImpl;

@RestController
@RequestMapping("/api/v1/")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	BookServiceImpl bookServiceImpl;

	// create book
	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
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

	// update books
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
		Book updateBook = bookServiceImpl.findBookByID(id);
		// orElseThrow(() -> new ResourceNotFoundException("Book not exist with id: " +
		// id));

		updateBook.setName(bookDetails.getName());
		updateBook.setAuthor(bookDetails.getAuthor());
		updateBook.setPublisher(bookDetails.getPublisher());
		updateBook.setPrice(bookDetails.getPrice());

		bookRepository.save(updateBook);

		return ResponseEntity.ok(updateBook);
	}

	// delete books by id
	@DeleteMapping("/books/{id}")
	public String deleteBookById(@PathVariable int id) {
		bookServiceImpl.deleteBookById(id);
		return "Book Deleted Successfully";
	}

	// delete all books
	@DeleteMapping("/books")
	public String deleteAllBooks() {
		bookServiceImpl.deleteAllBooks();
		return "All Books Deleted Successfully";
	}

}
