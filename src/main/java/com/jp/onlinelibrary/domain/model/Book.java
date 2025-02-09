package com.jp.onlinelibrary.domain.model;

import io.vavr.collection.Set;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
public class Book {

    private UUID id;

    private String title;

    private Set<Author> authors;

    private LocalDate publishedYear;

    private Long isbn;
}
