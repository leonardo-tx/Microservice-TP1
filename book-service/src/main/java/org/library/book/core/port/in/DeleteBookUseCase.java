package org.library.book.core.port.in;

import org.library.book.core.model.Book;

public interface DeleteBookUseCase {
    void delete(Book book);
}
