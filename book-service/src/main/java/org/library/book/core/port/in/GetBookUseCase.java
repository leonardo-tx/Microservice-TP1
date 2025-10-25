package org.library.book.core.port.in;

import org.library.book.core.model.Book;

public interface GetBookUseCase {
    Book getByIsbn(String isbn);
}
