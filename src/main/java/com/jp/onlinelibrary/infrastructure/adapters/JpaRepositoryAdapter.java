package com.jp.onlinelibrary.infrastructure.adapters;

import com.jp.onlinelibrary.infrastructure.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface JpaRepositoryAdapter extends JpaRepository<BookEntity, UUID> {

    @Query(value = "SELECT * FROM books WHERE books.isbn = :isbn", nativeQuery = true)
    BookEntity find(@Param("isbn") Long isbn);

    @Modifying
    @Query(value = "DELETE FROM books WHERE books.isbn = :isbn", nativeQuery = true)
    void delete(@Param("isbn") Long isbn);
}
