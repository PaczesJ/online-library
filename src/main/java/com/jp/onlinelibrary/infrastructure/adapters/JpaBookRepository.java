package com.jp.onlinelibrary.infrastructure.adapters;

import com.jp.onlinelibrary.domain.ports.BookRepository;
import com.jp.onlinelibrary.infrastructure.entities.BookEntity;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBookRepository implements BookRepository {

    private final JpaRepositoryAdapter adapter;

    public JpaBookRepository(JpaRepositoryAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Option<BookEntity> findByISBN(Long isbn) {
        return Option.of(adapter.find(isbn));
    }

    @Override
    public Set<BookEntity> all() {
        return HashSet.ofAll(adapter.findAll());
    }

    @Override
    public void save(BookEntity bookEntity) {
        adapter.save(bookEntity);
    }

    @Override
    public void delete(Long isbn) {
        adapter.delete(isbn);
    }
}
