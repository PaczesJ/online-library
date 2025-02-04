package com.jp.onlinelibrary.application.ports;

import com.jp.onlinelibrary.domain.entities.Book;
import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.UUID;

// port for db communication
public interface BookRepository {

    Option<Book> findByISBN(Long isbn);

    List<Book> all();

    void save(Book book);

    void delete(Book book);

}
