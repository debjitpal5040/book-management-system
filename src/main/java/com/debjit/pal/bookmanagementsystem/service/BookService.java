package com.debjit.pal.bookmanagementsystem.service;

import java.util.ArrayList;

import com.debjit.pal.bookmanagementsystem.model.Book;

public interface BookService {
	// CREATE
	
	// READ
	ArrayList<Book> findAllBooks();
    Book findBookByID(int id);
    
    // UPDATE
    
    // DELETE
    void deleteBookById(int id);
    void deleteAllBooks();
}
