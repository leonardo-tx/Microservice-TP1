package org.library.loan.core.port.in;

import org.library.loan.core.model.Loan;

import java.util.UUID;

public interface GetLoanUseCase {
    Loan getLoanById(UUID id);
}
