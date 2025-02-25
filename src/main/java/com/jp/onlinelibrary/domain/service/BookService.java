package com.jp.onlinelibrary.domain.service;

import com.jp.onlinelibrary.domain.model.Book;
import io.vavr.collection.Set;
import io.vavr.control.Option;

// port for domain operations
public interface BookService {

    Book addBook(Book book);

    Option<Book> getBook(String isbn);

    Set<Book> allBooks();

    void deleteBook(String isbn);

}
