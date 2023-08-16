package com.miha.librarymanagementsystem.services;

import com.miha.librarymanagementsystem.entities.Author;
import com.miha.librarymanagementsystem.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorByID(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);

        if (authorOptional.isPresent()) {
            return authorOptional.get();
        }
        return null;
    }

    @Override
    public Author updateAuthorByID(Author author, Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);

        if (authorOptional.isPresent()) {
            author.setId(id);
            return authorRepository.save(author);
        }
        return null;
    }

    @Override
    public String deleteAuthorByID(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);

        if (authorOptional.isPresent()) {
            authorRepository.deleteById(id);
            return "Author with ID " + id + " deleted successfully";
        }
        return null;
    }
}
