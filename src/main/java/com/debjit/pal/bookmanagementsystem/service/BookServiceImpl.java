package com.debjit.pal.bookmanagementsystem.service;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debjit.pal.bookmanagementsystem.dto.BookDto;
import com.debjit.pal.bookmanagementsystem.exception.ResourceNotFoundException;
import com.debjit.pal.bookmanagementsystem.model.Book;
import com.debjit.pal.bookmanagementsystem.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Book createBook(BookDto bookDto) {
        Book book = this.modelMapper.map(bookDto, Book.class);
        return this.bookRepository.save(book);
    }

    @Override
    public ArrayList<Book> findAllBooks() {
        ArrayList<Book> books = (ArrayList<Book>) this.bookRepository.findAll();
        return books;
    }

    @Override
    public BookDto findBookByID(int id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        BookDto bookDto = this.modelMapper.map(book, BookDto.class);
        return bookDto;
    }

    @Override
    public Book updateBook(int id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        if (bookDto.getName() != null) {
            book.setName(bookDto.getName());
        }
        if (bookDto.getAuthor() != null) {
            book.setAuthor(bookDto.getAuthor());
        }
        if (bookDto.getPublisher() != null) {
            book.setPublisher(bookDto.getPublisher());
        }
        if (bookDto.getisbn() != null) {
            book.setisbn(bookDto.getisbn());
        }
        return this.bookRepository.save(book);
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
