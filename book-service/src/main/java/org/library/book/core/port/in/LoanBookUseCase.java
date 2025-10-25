package org.library.book.core.port.in;

import org.library.book.core.model.Book;

import java.time.LocalDate;
import java.util.UUID;

public interface LoanBookUseCase {
    UUID loan(Book book, LocalDate dueDate);
}
