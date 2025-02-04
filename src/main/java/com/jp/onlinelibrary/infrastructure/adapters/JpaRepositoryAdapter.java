package com.jp.onlinelibrary.infrastructure.adapters;

import com.jp.onlinelibrary.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface JpaRepositoryAdapter extends JpaRepository<Book, UUID> {

    @Query(value = "SELECT * FROM book WHERE book.isbn = :isbn", nativeQuery = true)
    Book find(@Param("isbn") Long isbn);
}
