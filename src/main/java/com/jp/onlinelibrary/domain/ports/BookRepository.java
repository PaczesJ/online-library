package com.jp.onlinelibrary.domain.ports;

import com.jp.onlinelibrary.infrastructure.entities.BookEntity;
import io.vavr.collection.Set;
import io.vavr.control.Option;

// port for db communication
public interface BookRepository {

    Option<BookEntity> findByISBN(Long isbn);

    Set<BookEntity> all();

    void save(BookEntity bookEntity);

    void delete(BookEntity bookEntity);

}
