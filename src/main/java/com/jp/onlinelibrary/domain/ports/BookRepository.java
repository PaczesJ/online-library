package com.jp.onlinelibrary.domain.ports;

import com.jp.onlinelibrary.domain.model.Book;
import io.vavr.collection.Set;
import io.vavr.control.Option;

// port for db communication
public interface BookRepository {

    Option<Book> findByISBN(String isbn);

    Set<Book> all();

    Book save(Book book);

    void delete(String isbn);
}
