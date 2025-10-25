package org.library.book.core.port.in;

import org.library.book.core.model.Book;

public interface AddBookUseCase {
    Book add(Book book);
}
