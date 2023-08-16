package com.miha.librarymanagementsystem.services;

import com.miha.librarymanagementsystem.entities.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);

    List<Book> getAllBook();

    Book getBookByID(Long id);

    Book updateBookByID(Book book, Long id);

    String deleteBookByID(Long id);
}
