package org.library.loan.core.port.in;

import org.library.loan.core.model.Loan;

public interface CreateLoanUseCase {
    Loan create(Loan loan);
}
