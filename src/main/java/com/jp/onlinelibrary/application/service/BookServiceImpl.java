package com.jp.onlinelibrary.application.service;

import com.jp.onlinelibrary.domain.ports.BookRepository;
import com.jp.onlinelibrary.domain.service.BookService;
import com.jp.onlinelibrary.domain.model.Book;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Option<Book> getBook(String isbn) {
        return Option.of(bookRepository.findByISBN(isbn).getOrElseThrow(() -> new RuntimeException("Book not found")));
    }

    @Override
    public Set<Book> allBooks() {
        return bookRepository.all();
    }

    @Override
    public void deleteBook(String isbn) {
        bookRepository.delete(isbn);
    }
}
