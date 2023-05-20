package com.debjit.pal.bookmanagementsystem.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debjit.pal.bookmanagementsystem.exception.ResourceNotFoundException;
import com.debjit.pal.bookmanagementsystem.model.Book;
import com.debjit.pal.bookmanagementsystem.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    // @Override
    // public Book createBook() {
    //
    // }

    @Override
    public ArrayList<Book> findAllBooks() {
        return (ArrayList<Book>) bookRepository.findAll();
    }

    @Override
    public Book findBookByID(int id) {
        Optional<Book> opt = bookRepository.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public void deleteBookById(int id) {
        if (findBookByID(id) == null) {
            throw new ResourceNotFoundException("Book does not exist with id: " + id);
        } else {
            bookRepository.deleteById(id);
        }
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }
}
