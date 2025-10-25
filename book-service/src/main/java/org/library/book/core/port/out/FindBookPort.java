package org.library.book.core.port.out;

import org.library.book.core.model.Book;

import java.util.Optional;

public interface FindBookPort {
    Optional<Book> findByIsbn(String isbn);
}
