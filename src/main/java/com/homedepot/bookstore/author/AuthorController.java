package com.homedepot.bookstore.author;

import com.homedepot.bookstore.author.exceptions.AuthorNotFoundException;
import com.homedepot.bookstore.book.BookRepository;
import com.homedepot.bookstore.domain.Author;
import com.homedepot.bookstore.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) throws AuthorNotFoundException {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException());
    }

    @PostMapping("/{id}/books")
    public Book addBook(@PathVariable("id") Long id, @Valid @RequestBody Book book) throws AuthorNotFoundException {
        return authorRepository.findById(id).map(author -> {
            book.setAuthor(author);
            return bookRepository.save(book);
        }).orElseThrow(() -> new AuthorNotFoundException());
    }
    @PostMapping
    public Author postAuthor(@Valid @RequestBody Author author) {
        return authorRepository.save(author);
    }
}
