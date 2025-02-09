package com.jp.onlinelibrary.application.ports;

import com.jp.onlinelibrary.domain.ports.BookRepository;
import com.jp.onlinelibrary.infrastructure.entities.AuthorEntity;
import com.jp.onlinelibrary.infrastructure.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public abstract class BookEntityRepositoryTest {


    private static final long ISBN = 9788375780659L;

    @Test
    void createReadUpdateDelete() {

        // given
        AuthorEntity authorEntityNo1 = AuthorEntity.builder()
                .name("Andrzej")
                .surname("Sapkowski")
                .birthDate(LocalDate.of(1948, 6, 21))
                .bookEntities(List.of())
                .build();

        BookEntity bookEntityNo1 = BookEntity.builder()
                .title("The Witcher: Blood of Elves")
                .authorEntities(Set.of(authorEntityNo1))
                .publishedYear(LocalDate.of(1994, 1, 1))
                .isbn(ISBN)
                .build();

        // when
        bookRepository().save(bookEntityNo1);

        // then
        BookEntity bookEntity = bookRepository().findByISBN(ISBN).get();
        assertThat(bookEntity.getTitle()).isEqualTo(bookEntityNo1.getTitle());
    }

    @Test
    void all() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    public abstract BookRepository bookRepository();
}