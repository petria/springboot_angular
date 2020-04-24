package org.freakz.books.jpa.repository;

import org.freakz.books.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
