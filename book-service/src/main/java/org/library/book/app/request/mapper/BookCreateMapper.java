package org.library.book.app.request.mapper;

import org.library.book.app.request.dto.BookCreateDTO;
import org.library.book.core.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookCreateMapper {
    public Book toModel(BookCreateDTO entity) {
        return new Book(entity.getIsbn(), entity.getTitle(), entity.getAuthor(), entity.getCount());
    }
}
