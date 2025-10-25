package org.library.loan.core.port.out;

import org.library.loan.core.model.Loan;

public interface SaveLoanPort {
    Loan save(Loan loan);
}
