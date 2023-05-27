package com.debjit.pal.bookmanagementsystem.dto;

import jakarta.validation.constraints.Size;

public class BookDto {

    private String name;

    private String author;

    private String publisher;

    @Size(min = 13, max = 13, message = "isbn must be 13 characters long")
    private String isbn;

    public BookDto() {
        super();
    }

    public BookDto(String name, String author, String publisher, String isbn) {
        super();
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public @Size(min = 13, max = 13, message = "isbn must be of 13 characters") String getisbn() {
        return isbn;
    }

    public void setisbn(@Size(min = 13, max = 13, message = "isbn must be of 13 characters") String isbn) {
        this.isbn = isbn;
    }
}
