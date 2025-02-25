package com.jp.onlinelibrary.infrastructure.adapters;

import com.jp.onlinelibrary.infrastructure.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JpaBookEntityRepositoryTest {

    @Autowired
    private JpaBookRepository jpaBookRepository;

    private static final String ISBN = "8370540791";

    @Test
    void createReadUpdateDelete() {

        // given
//        Author authorNo1 = Author.builder()
//                .name("Andrzej")
//                .surname("Sapkowski")
//                .birthDate(LocalDate.of(1948, 6, 21))
//                .books(List.of())
//                .build();

        BookEntity bookEntityNo1 = BookEntity.builder()
                .title("The Witcher: Blood of Elves")
                .publishedYear(LocalDate.of(1994, 1, 1))
                .isbn(ISBN)
                .build();

        // when
//        jpaBookRepository.save(bookEntityNo1);

        // then
//        BookEntity bookEntity = jpaBookRepository.findByISBN(ISBN).get();
//        assertThat(bookEntity.getTitle()).isEqualTo(bookEntityNo1.getTitle());

//        jpaBookRepository.delete(bookEntity.getIsbn());
        // assert non-existence of entity / its proper deletion
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