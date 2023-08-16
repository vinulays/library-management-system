package com.miha.librarymanagementsystem.controllers;

import com.miha.librarymanagementsystem.entities.Book;
import com.miha.librarymanagementsystem.services.BookService;
import com.miha.librarymanagementsystem.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookServiceImpl bookService;

    @GetMapping
    public ResponseEntity<?> getAllBook() {
        List<Book> books = bookService.getAllBook();
        if (books.isEmpty()) {
            return new ResponseEntity<>("Book list is empty", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookByID(@PathVariable("id") Long id) {
        Book book = bookService.getBookByID(id);

        if (book == null) {
            return new ResponseEntity<>("Book not found!", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookByID(@RequestBody Book book, @PathVariable("id") Long id) {
        Book updatedBook = bookService.updateBookByID(book, id);
        if (updatedBook == null) {
            return new ResponseEntity<>("Book ID not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookByID(@PathVariable("id") Long id) {
        String result = bookService.deleteBookByID(id);
        if (result == null) {
            return new ResponseEntity<>("Book ID not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

}
