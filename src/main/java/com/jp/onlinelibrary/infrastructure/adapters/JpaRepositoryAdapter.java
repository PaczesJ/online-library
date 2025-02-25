package com.jp.onlinelibrary.infrastructure.adapters;

import com.jp.onlinelibrary.infrastructure.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.UUID;

public interface JpaRepositoryAdapter extends JpaRepository<BookEntity, UUID> {

    @Query(value = "SELECT * FROM books WHERE books.isbn = :isbn", nativeQuery = true)
    BookEntity find(@Param("isbn") String isbn);

    @Modifying
    @Query(value = "DELETE FROM books WHERE books.isbn = :isbn", nativeQuery = true)
    void delete(@Param("isbn") String isbn);

    @Modifying
    @Query(value = "INSERT INTO books VALUES (books.isbn, books.published_year, books.title)", nativeQuery = true)
    BookEntity save(@Param("title") String title , @Param("publishedYear") LocalDate publishedYear , @Param("isbn") String isbn);
}
