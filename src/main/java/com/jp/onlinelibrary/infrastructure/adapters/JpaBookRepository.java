package com.jp.onlinelibrary.infrastructure.adapters;

import com.jp.onlinelibrary.application.mapper.BookMapper;
import com.jp.onlinelibrary.domain.ports.BookRepository;
import com.jp.onlinelibrary.domain.model.Book;
import com.jp.onlinelibrary.infrastructure.entities.BookEntity;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.springframework.stereotype.Repository;

import static com.jp.onlinelibrary.application.mapper.BookMapper.toDomain;

@Repository
public class JpaBookRepository implements BookRepository {

    private final JpaRepositoryAdapter adapter;

    public JpaBookRepository(JpaRepositoryAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Option<Book> findByISBN(String isbn) {
        return Option.of(adapter.find(isbn)).map(BookMapper::toDomain);
    }

    @Override
    public Set<Book> all() {
        return HashSet.ofAll(adapter.findAll().stream().map(BookMapper::toDomain));
    }

    @Override
    public Book save(Book book) {
        BookEntity entity = BookEntity.builder()
                .title(book.getTitle())
                .publishedYear(book.getPublishedYear())
                .isbn(book.getIsbn())
                .build();
        adapter.save(entity.getTitle(), entity.getPublishedYear(), entity.getIsbn());
        return toDomain(entity);
    }

    @Override
    public void delete(String isbn) {
        adapter.delete(isbn);
    }
}
