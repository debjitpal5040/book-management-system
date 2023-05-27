package com.debjit.pal.bookmanagementsystem.service;

import java.util.ArrayList;

import com.debjit.pal.bookmanagementsystem.dto.BookDto;
import com.debjit.pal.bookmanagementsystem.model.Book;

public interface BookService {
    // CREATE
    public Book createBook(BookDto bookdDto);

    // READ
    public ArrayList<Book> findAllBooks();
    public BookDto findBookByID(int id);

    // UPDATE
    public Book updateBook(int id, BookDto bookDto);

    // DELETE
    public void deleteBookById(int id);
    public void deleteAllBooks();
}
