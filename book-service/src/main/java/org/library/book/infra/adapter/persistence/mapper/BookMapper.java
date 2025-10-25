package org.library.book.infra.adapter.persistence.mapper;

import org.library.book.core.model.Book;
import org.library.book.infra.adapter.persistence.entity.BookJpa;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toModel(BookJpa entity) {
        return new Book(entity.getIsbn(), entity.getTitle(), entity.getAuthor(), entity.getCount());
    }

    public BookJpa toEntity(Book model) {
        return BookJpa.builder()
                .isbn(model.getIsbn())
                .title(model.getTitle())
                .author(model.getAuthor())
                .count(model.getCount())
                .build();
    }
}
