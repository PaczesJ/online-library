package com.jp.onlinelibrary.application.dto;

import com.jp.onlinelibrary.domain.model.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

// rekord jest niemutowalny, co zapobiega przypadkowym zmianom
// generuje gettery, setter, equals(), hashCode(), toString()
public record CreateBookRequest(
        @NotBlank String title,
        @NotBlank Author author,
        @NotNull LocalDate publicationYear,
        @NotNull String isbn
) {}
