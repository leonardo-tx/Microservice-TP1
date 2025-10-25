package org.library.loan.core.port.out;

import org.library.loan.core.model.Loan;

import java.util.Optional;
import java.util.UUID;

public interface FindLoanPort {
    Optional<Loan> findById(UUID id);
}
