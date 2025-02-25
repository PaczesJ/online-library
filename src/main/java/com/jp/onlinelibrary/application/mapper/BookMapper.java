package com.jp.onlinelibrary.application.mapper;

import com.jp.onlinelibrary.domain.model.Book;
import com.jp.onlinelibrary.infrastructure.entities.BookEntity;
import io.vavr.collection.HashSet;

import java.util.stream.Collectors;


public class BookMapper {
    public static Book toDomain(BookEntity entity) {
        return Book.builder()
                .title(entity.getTitle())
                .publishedYear(entity.getPublishedYear())
                .isbn(entity.getIsbn())
                .authors(HashSet.ofAll(entity.getAuthors().stream()
                        .map(AuthorMapper::toAuthor)))
                .build();
    }

    public static BookEntity toEntity(Book book) {
        return BookEntity.builder()
                .title(book.getTitle())
                .publishedYear(book.getPublishedYear())
                .isbn(book.getIsbn())
                .authors(book.getAuthors().toStream()
                        .map(AuthorMapper::toAuthorEntity)
                        .collect(Collectors.toSet()))
                .build();
    }

}
