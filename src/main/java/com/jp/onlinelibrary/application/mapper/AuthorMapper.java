package com.jp.onlinelibrary.application.mapper;

import com.jp.onlinelibrary.domain.model.Author;
import com.jp.onlinelibrary.infrastructure.entities.AuthorEntity;

public class AuthorMapper {
    protected static AuthorEntity toAuthorEntity(Author author) {
        return AuthorEntity.builder()
                .name(author.getName())
                .surname(author.getSurname())
                .birthDate(author.getBirthDate())
                .build();
    }


    protected static Author toAuthor(AuthorEntity entity) {
        return Author.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .birthDate(entity.getBirthDate())
                .build();
    }
}
