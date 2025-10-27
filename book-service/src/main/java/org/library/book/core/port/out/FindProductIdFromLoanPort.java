package org.library.book.core.port.out;

import java.util.Optional;
import java.util.UUID;

public interface FindProductIdFromLoanPort {
    Optional<String> findProductIdByLoanId(UUID loanId);
}
