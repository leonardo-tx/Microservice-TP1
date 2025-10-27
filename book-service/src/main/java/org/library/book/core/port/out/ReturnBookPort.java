package org.library.book.core.port.out;

import java.util.UUID;

public interface ReturnBookPort {
    boolean returnBook(UUID loanId);
}
