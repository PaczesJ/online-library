package com.jp.onlinelibrary.domain.model;

import io.vavr.collection.HashSet;
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

    private HashSet<Author> authors;

    private LocalDate publishedYear;

    private String isbn;
}
