package com.jp.onlinelibrary.infrastructure.adapters;

import com.jp.onlinelibrary.application.ports.BookRepository;
import com.jp.onlinelibrary.domain.entities.Book;
import io.vavr.collection.List;
import io.vavr.control.Option;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBookRepository implements BookRepository {

    private final JpaRepositoryAdapter adapter;

    public JpaBookRepository(JpaRepositoryAdapter adapter) {
        this.adapter = adapter;
    }
    @Override
    public Option<Book> findByISBN(Long isbn) {
        return Option.of(adapter.find(isbn));
    }

    @Override
    public List<Book> all() {
        return null;
    }

    @Override
    public void save(Book book) {
        adapter.save(book);

    }

    @Override
    public void delete(Book book) {
        adapter.delete(book);
    }
}
