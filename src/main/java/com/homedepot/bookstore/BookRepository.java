package com.homedepot.bookstore;

import com.homedepot.bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {
}
