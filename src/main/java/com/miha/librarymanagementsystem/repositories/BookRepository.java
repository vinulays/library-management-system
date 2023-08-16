package com.miha.librarymanagementsystem.repositories;

import com.miha.librarymanagementsystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
