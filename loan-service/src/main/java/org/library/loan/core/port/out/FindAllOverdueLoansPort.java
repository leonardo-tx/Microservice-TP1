package org.library.loan.core.port.out;

import org.library.loan.core.model.Loan;

import java.util.List;

public interface FindAllOverdueLoansPort {
    List<Loan> findAllOverdue();
}
