package org.library.book.core.port.in;

import org.library.book.core.model.Book;

import java.util.List;

public interface GetAllBooksUseCase {
    List<Book> getAll();
}
