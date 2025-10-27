package org.library.loan.core.port.in;

import org.library.loan.core.model.Loan;

import java.util.List;
import java.util.UUID;

public interface LoanFacade {
    Loan closeById(String productType, UUID id);
    Loan create(Loan loan);
    List<Loan> getAllOverdue(String productType);
    Loan getLoanById(String productType, UUID id);
}
