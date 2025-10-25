package org.library.book.core.service;

import lombok.RequiredArgsConstructor;
import org.library.book.core.model.Book;
import org.library.book.core.port.in.LoanBookUseCase;
import org.library.book.core.port.out.LoanBookPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoanBookService implements LoanBookUseCase {
    private final LoanBookPort loanBookPort;

    @Override
    public UUID loan(Book book, LocalDate dueDate) {
        return loanBookPort.loan(book, dueDate);
    }
}
