package org.library.book.core.service;

import lombok.RequiredArgsConstructor;
import org.library.book.core.model.Book;
import org.library.book.core.port.in.LoanBookUseCase;
import org.library.book.core.port.out.LoanBookPort;
import org.library.book.core.port.out.SaveBookPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoanBookService implements LoanBookUseCase {
    private final LoanBookPort loanBookPort;
    private final SaveBookPort saveBookPort;

    @Override
    public UUID loan(Book book, LocalDate dueDate) {
        UUID loanId = loanBookPort.loan(book, dueDate);
        book.decreaseCount();
        saveBookPort.save(book);

        return loanId;
    }
}
