package org.library.loan.core.port.in;

import org.library.loan.core.model.Loan;

import java.util.List;

public interface GetAllOverdueLoansUseCase {
    List<Loan> getAllOverdue(String productType);
}
