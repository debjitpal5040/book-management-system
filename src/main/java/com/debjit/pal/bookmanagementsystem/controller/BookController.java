package com.debjit.pal.bookmanagementsystem.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debjit.pal.bookmanagementsystem.dto.BookDto;
import com.debjit.pal.bookmanagementsystem.model.Book;
import com.debjit.pal.bookmanagementsystem.service.BookServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1")
public class BookController {

	@Autowired
	private BookServiceImpl bookServiceImpl;

	// create book rest api
	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody @Valid BookDto bookDto) {
		Book newBook = bookServiceImpl.createBook(bookDto);
		return new ResponseEntity<Book>(newBook, HttpStatus.CREATED);
	}

	// get all books rest api
	@GetMapping("/books")
	public ResponseEntity<ArrayList<Book>> getAllBooks() {
		ArrayList<Book> books = bookServiceImpl.findAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	// get book by id rest api
	@GetMapping("/books/{id}")
	public ResponseEntity<BookDto> getBookUsingId(@PathVariable("id") int id) {
		// convert book to bookDto
		BookDto bookDto = this.bookServiceImpl.findBookByID(id);
		return new ResponseEntity<BookDto>(bookDto, HttpStatus.OK);
	}

	// update book rest api
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody @Valid
	BookDto bookDto) {
		Book updatedBook = bookServiceImpl.updateBook(id, bookDto);
		return new ResponseEntity<Book>(updatedBook, HttpStatus.OK);
	}

	// delete book rest api
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable int id) {
		bookServiceImpl.deleteBookById(id);
		return "Book deleted with id: " + id;
	}

	// delete all books rest api
	@DeleteMapping("/books")
	public String deleteAllBooks() {
		bookServiceImpl.deleteAllBooks();
		return "All books deleted";
	}
}
