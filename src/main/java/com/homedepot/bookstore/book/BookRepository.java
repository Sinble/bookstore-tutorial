package com.homedepot.bookstore.book;

import com.homedepot.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
}
