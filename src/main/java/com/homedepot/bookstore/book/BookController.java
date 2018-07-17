package com.homedepot.bookstore.book;

import com.homedepot.bookstore.book.exceptions.BookNotFoundException;
import com.homedepot.bookstore.domain.Author;
import com.homedepot.bookstore.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book postBooks(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") Long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
    }

    @GetMapping("/{id}/author")
    public Author getAuthor(@PathVariable("id") Long id) throws BookNotFoundException {
        return bookRepository.findById(id).map(book -> book.getAuthor()).orElseThrow(() -> new BookNotFoundException());
    }
}
