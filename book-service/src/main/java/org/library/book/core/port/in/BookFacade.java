package org.library.book.core.port.in;

import org.library.book.core.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface BookFacade {
    Book add(Book book);
    Book update(Book book);
    void deleteByIsbn(String isbn);
    List<Book> getAll();
    Book getByIsbn(String isbn);
    UUID loanByIsbn(String isbn, LocalDate dueDate);
}
