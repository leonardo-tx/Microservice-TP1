package org.library.book.core.facade;

import lombok.RequiredArgsConstructor;
import org.library.book.core.model.Book;
import org.library.book.core.port.in.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BookFacadeImpl implements BookFacade {
    private final AddBookUseCase addBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final GetAllBooksUseCase getAllBooksUseCase;
    private final GetBookUseCase getBookUseCase;
    private final LoanBookUseCase loanBookUseCase;
    private final ReturnBookUseCase returnBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;

    @Override
    public Book add(Book book) {
        return addBookUseCase.add(book);
    }

    @Override
    public Book update(Book book) {
        return updateBookUseCase.update(book);
    }

    @Override
    public void deleteByIsbn(String isbn) {
        Book book = getBookUseCase.getByIsbn(isbn);
        deleteBookUseCase.delete(book);
    }

    @Override
    public List<Book> getAll() {
        return getAllBooksUseCase.getAll();
    }

    @Override
    public Book getByIsbn(String isbn) {
        return getBookUseCase.getByIsbn(isbn);
    }

    @Override
    public UUID loanByIsbn(String isbn, LocalDate dueDate) {
        Book book = getBookUseCase.getByIsbn(isbn);
        return loanBookUseCase.loan(book, dueDate);
    }

    @Override
    public void returnByLoanId(UUID loanId) {
        returnBookUseCase.returnBook(loanId);
    }
}
