package com.jp.onlinelibrary.application.ports;

import com.jp.onlinelibrary.domain.model.Author;
import com.jp.onlinelibrary.domain.model.Book;
import com.jp.onlinelibrary.domain.ports.BookRepository;
import io.vavr.collection.HashSet;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public abstract class BookEntityRepositoryTest {


    private static final String ISBN = "8370540791";

    @Test
    void createReadUpdateDelete() {

        // given
        Author author = Author.builder()
                .name("Andrzej")
                .surname("Sapkowski")
                .birthDate(LocalDate.of(1948, 6, 21))
                .build();

        Book book = Book.builder()
                .title("The Witcher: Blood of Elves")
                .authors(HashSet.of(author))
                .publishedYear(LocalDate.of(1994, 1, 1))
                .isbn(ISBN)
                .build();

        // when
        bookRepository().save(book);

        // then
//        BookEntity bookEntity = bookRepository().findByISBN(ISBN).get();
//        assertThat(bookEntity.getTitle()).isEqualTo(bookEntityNo1.getTitle());
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