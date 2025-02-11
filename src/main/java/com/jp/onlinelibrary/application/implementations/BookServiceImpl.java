package com.jp.onlinelibrary.application.implementations;

import com.jp.onlinelibrary.application.ports.BookService;
import com.jp.onlinelibrary.domain.model.Author;
import com.jp.onlinelibrary.domain.model.Book;
import com.jp.onlinelibrary.domain.ports.BookRepository;
import com.jp.onlinelibrary.infrastructure.entities.AuthorEntity;
import com.jp.onlinelibrary.infrastructure.entities.BookEntity;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import io.vavr.control.Option;

import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(toEntity(book));
    }

    @Override
    public Option<Book> getBook(Long isbn) {
        BookEntity book = bookRepository.findByISBN(isbn).getOrElseThrow(() -> new RuntimeException("Book not found"));
        return Option.of(toDomain(book));
    }

    @Override
    public Set<Book> allBooks() {
        return bookRepository.all().map(BookServiceImpl::toDomain);
    }
    @Override
    public void deleteBook(Long isbn) {
        bookRepository.delete(isbn);
    }

    private static BookEntity toEntity(Book book) {
        return BookEntity.builder()
                .title(book.getTitle())
                .publishedYear(book.getPublishedYear())
                .isbn(book.getIsbn())
                .authors(
                        book.getAuthors().toStream()
                                .map(BookServiceImpl::toAuthorEntity)
                                .collect(Collectors.toSet()))
                .build();
    }

    private static AuthorEntity toAuthorEntity(Author author) {
        return AuthorEntity.builder()
                .name(author.getName())
                .surname(author.getSurname())
                .birthDate(author.getBirthDate())
                .build();
    }

    private static Book toDomain(BookEntity entity) {
        return Book.builder()
                .title(entity.getTitle())
                .publishedYear(entity.getPublishedYear())
                .isbn(entity.getIsbn())
                .authors(HashSet.ofAll(entity.getAuthors().stream()
                        .map(BookServiceImpl::toAuthor)))
                .build();
    }

    private static Author toAuthor(AuthorEntity entity) {
        return Author.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .birthDate(entity.getBirthDate())
                .build();
    }
}
