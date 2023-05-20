package com.debjit.pal.bookmanagementsystem.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debjit.pal.bookmanagementsystem.exception.ResourceNotFoundException;
import com.debjit.pal.bookmanagementsystem.model.Book;
import com.debjit.pal.bookmanagementsystem.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public ArrayList<Book> findAllBooks() {
        return (ArrayList<Book>) bookRepository.findAll();
    }

    @Override
    public Book findBookByID(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            throw new ResourceNotFoundException("Book", "id", id);
        }
    }

    @Override
    public Book updateBook(int id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));

        if (bookDetails.getName() != null) {
            book.setName(bookDetails.getName());
        }
        if (bookDetails.getAuthor() != null) {
            book.setAuthor(bookDetails.getAuthor());
        }
        if (bookDetails.getPublisher() != null) {
            book.setPublisher(bookDetails.getPublisher());
        }
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(int id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        bookRepository.delete(book);
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }
}
