package org.library.book.app.request.mapper;

import org.library.book.app.request.dto.BookUpdateDTO;
import org.library.book.core.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookUpdateMapper {
    public Book toModel(BookUpdateDTO entity, String isbn) {
        return new Book(isbn, entity.getTitle(), entity.getAuthor(), entity.getCount());
    }
}
