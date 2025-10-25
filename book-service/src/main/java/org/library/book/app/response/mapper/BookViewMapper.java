package org.library.book.app.response.mapper;

import org.library.book.app.response.dto.BookViewDTO;
import org.library.book.core.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookViewMapper {
    public BookViewDTO toEntity(Book book) {
        return BookViewDTO.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .count(book.getCount())
                .build();
    }
}
