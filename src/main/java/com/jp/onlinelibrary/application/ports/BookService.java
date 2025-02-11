package com.jp.onlinelibrary.application.ports;

import com.jp.onlinelibrary.domain.model.Book;
import io.vavr.collection.Set;
import io.vavr.control.Option;

// port for domain operations
public interface BookService {

    void addBook(Book book);

    Option<Book> getBook(Long isbn);

    Set<Book> allBooks();

    void deleteBook(Long isbn);

}
