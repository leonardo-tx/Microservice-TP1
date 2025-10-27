package org.library.book.core.service;

import lombok.RequiredArgsConstructor;
import org.library.book.core.exception.NotFoundException;
import org.library.book.core.model.Book;
import org.library.book.core.port.in.ReturnBookUseCase;
import org.library.book.core.port.out.FindBookPort;
import org.library.book.core.port.out.FindProductIdFromLoanPort;
import org.library.book.core.port.out.ReturnBookPort;
import org.library.book.core.port.out.SaveBookPort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReturnBookService implements ReturnBookUseCase {
    private final ReturnBookPort returnBookPort;
    private final FindProductIdFromLoanPort findProductIdFromLoanPort;
    private final SaveBookPort saveBookPort;
    private final FindBookPort findBookPort;

    @Override
    public void returnBook(UUID loanId) {
        if (!returnBookPort.returnBook(loanId)) {
            throw new NotFoundException("loan.not.found", "The book loan does not exist.");
        }
        String productId = findProductIdFromLoanPort.findProductIdByLoanId(loanId).get();
        Optional<Book> bookOptional = findBookPort.findByIsbn(productId);
        if (bookOptional.isEmpty()) {
            throw new NotFoundException("book.not.found", "The book was not found to.");
        }
        Book book = bookOptional.get();

        book.increaseCount();
        saveBookPort.save(book);
    }
}
