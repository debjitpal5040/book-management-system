package com.debjit.pal.bookmanagementsystem.service;

import java.util.ArrayList;

import com.debjit.pal.bookmanagementsystem.model.Book;

public interface BookService {
    // CREATE
    Book saveBook(Book book);

    // READ
    ArrayList<Book> findAllBooks();
    Book findBookByID(int id);

    // UPDATE
    Book updateBook(int id, Book bookDetails);

    // DELETE
    void deleteBookById(int id);
    void deleteAllBooks();
}
