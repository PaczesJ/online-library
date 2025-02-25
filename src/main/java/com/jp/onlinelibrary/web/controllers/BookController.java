package com.jp.onlinelibrary.web.controllers;

import com.jp.onlinelibrary.application.dto.CreateBookRequest;
import com.jp.onlinelibrary.domain.model.Book;
import com.jp.onlinelibrary.domain.service.BookService;
import io.vavr.collection.Set;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.getBook(isbn).getOrElseThrow(() -> new RuntimeException("Book not found")));
    }

    @GetMapping
    public ResponseEntity<Set<Book>> allBooks() {
        return ResponseEntity.ok(bookService.allBooks());
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody CreateBookRequest request) {
        Book createdBook = bookService.addBook(Book.builder()
                .title(request.title())
                .publishedYear(request.publicationYear())
                .isbn(request.isbn())
                .build());
        return ResponseEntity
                .created(URI.create("/books/" + createdBook.getIsbn()))
                .body(createdBook);
    }
}
