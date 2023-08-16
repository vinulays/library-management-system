package com.miha.librarymanagementsystem.services;

import com.miha.librarymanagementsystem.entities.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);

    List<Author> getAllAuthor();

    Author getAuthorByID(Long id);

    Author updateAuthorByID(Author author, Long id);

    String deleteAuthorByID(Long id);
}
