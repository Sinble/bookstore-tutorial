package com.homedepot.bookstore.author;

import com.homedepot.bookstore.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
