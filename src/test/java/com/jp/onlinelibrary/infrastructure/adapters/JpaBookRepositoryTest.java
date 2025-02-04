package com.jp.onlinelibrary.infrastructure.adapters;

import com.jp.onlinelibrary.domain.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JpaBookRepositoryTest {

    @Autowired
    private JpaBookRepository jpaBookRepository;

    private static final long ISBN = 9788375780659L;

    @Test
    void createReadUpdateDelete() {

        // given
//        Author authorNo1 = Author.builder()
//                .name("Andrzej")
//                .surname("Sapkowski")
//                .birthDate(LocalDate.of(1948, 6, 21))
//                .books(List.of())
//                .build();

        Book bookNo1 = Book.builder()
                .title("The Witcher: Blood of Elves")
                .authors(Set.of())
                .publishedYear(LocalDate.of(1994, 1, 1))
                .isbn(ISBN)
                .build();

        // when
        jpaBookRepository.save(bookNo1);

        // then
        Book book = jpaBookRepository.findByISBN(ISBN).get();
        assertThat(book.getTitle()).isEqualTo(bookNo1.getTitle());

        jpaBookRepository.delete(book);
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

}