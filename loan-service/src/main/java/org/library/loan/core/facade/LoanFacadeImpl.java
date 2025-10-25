package org.library.loan.core.facade;

import lombok.RequiredArgsConstructor;
import org.library.loan.core.model.Loan;
import org.library.loan.core.port.in.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LoanFacadeImpl implements LoanFacade {
    private final CloseLoanUseCase closeLoanUseCase;
    private final CreateLoanUseCase createLoanUseCase;
    private final GetAllOverdueLoansUseCase getAllOverdueLoansUseCase;
    private final GetLoanUseCase getLoanUseCase;

    @Override
    public Loan closeById(UUID id) {
        Loan loan = getLoanUseCase.getLoanById(id);
        return closeLoanUseCase.close(loan);
    }

    @Override
    public Loan create(Loan loan) {
        return createLoanUseCase.create(loan);
    }

    @Override
    public List<Loan> getAllOverdue() {
        return getAllOverdueLoansUseCase.getAllOverdue();
    }

    @Override
    public Loan getLoanById(UUID id) {
        return getLoanUseCase.getLoanById(id);
    }
}
