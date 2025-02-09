package com.jp.onlinelibrary.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
public class Author {

    private UUID id;

    private String name;

    private String surname;

    private LocalDate birthDate;

}
