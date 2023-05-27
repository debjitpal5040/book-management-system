package com.debjit.pal.bookmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debjit.pal.bookmanagementsystem.model.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {

}
