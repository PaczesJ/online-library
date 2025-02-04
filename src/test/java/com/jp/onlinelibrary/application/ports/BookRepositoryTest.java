package com.jp.onlinelibrary.application.ports;

import com.jp.onlinelibrary.domain.entities.Author;
import com.jp.onlinelibrary.domain.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public abstract class BookRepositoryTest {


    private static final long ISBN = 9788375780659L;

    @Test
    void createReadUpdateDelete() {

        // given
        Author authorNo1 = Author.builder()
                .name("Andrzej")
                .surname("Sapkowski")
                .birthDate(LocalDate.of(1948, 6, 21))
                .books(List.of())
                .build();

        Book bookNo1 = Book.builder()
                .title("The Witcher: Blood of Elves")
                .authors(Set.of(authorNo1))
                .publishedYear(LocalDate.of(1994, 1, 1))
                .isbn(ISBN)
                .build();

        // when
        bookRepository().save(bookNo1);

        // then
        Book book = bookRepository().findByISBN(ISBN).get();
        assertThat(book.getTitle()).isEqualTo(bookNo1.getTitle());
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