package org.library.book.core.port.in;

import org.library.book.core.model.Book;

public interface UpdateBookUseCase {
    Book update(Book book);
}
