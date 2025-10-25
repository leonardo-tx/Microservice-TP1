package org.library.book.core.port.out;

import org.library.book.core.model.Book;

import java.time.LocalDate;
import java.util.UUID;

public interface LoanBookPort {
    UUID loan(Book book, LocalDate dueDate);
}
