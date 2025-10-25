package org.library.book.core.port.out;

import org.library.book.core.model.Book;

public interface DeleteBookPort {
    void delete(Book book);
}
