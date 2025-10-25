package org.library.book.core.port.out;

import org.library.book.core.model.Book;

import java.util.List;

public interface FindAllBookPort {
    List<Book> findAll();
}
