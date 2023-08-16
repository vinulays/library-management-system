package com.miha.librarymanagementsystem.controllers;


import com.miha.librarymanagementsystem.entities.Author;
import com.miha.librarymanagementsystem.services.AuthorService;
import com.miha.librarymanagementsystem.services.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    AuthorServiceImpl authorService;

    @GetMapping
    public ResponseEntity<?> getAllAuthor(@RequestParam(required = false) Long id) {

        if (id == null) {
            List<Author> authors = authorService.getAllAuthor();
            if (authors.isEmpty()) {
                return new ResponseEntity<>("Author list is empty", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(authors, HttpStatus.OK);

        } else {
            Author author = authorService.getAuthorByID(id);
            if (author == null) {
                return new ResponseEntity<>("Author not found!", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(author, HttpStatus.OK);
        }


    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<?> getAuthorByID(@RequestParam Long id) {
//        Author author = authorService.getAuthorByID(id);
//
//        if (author == null) {
//            return new ResponseEntity<>("Author not found!", HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(author, HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthorByID(@RequestBody Author author, @PathVariable("id") Long id) {
        Author updatedAuthor = authorService.updateAuthorByID(author, id);
        if (updatedAuthor == null) {
            return new ResponseEntity<>("Author ID not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorByID(@PathVariable("id") Long id) {
        String result = authorService.deleteAuthorByID(id);
        if (result == null) {
            return new ResponseEntity<>("Author ID not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
