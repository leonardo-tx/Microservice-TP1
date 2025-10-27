package org.library.book.core.port.in;

import java.util.UUID;

public interface ReturnBookUseCase {
    void returnBook(UUID loanId);
}
