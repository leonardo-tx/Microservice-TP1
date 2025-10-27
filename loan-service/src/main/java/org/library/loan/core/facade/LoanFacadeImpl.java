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
    public Loan closeById(String productType, UUID id) {
        Loan loan = getLoanUseCase.getLoanById(productType, id);
        return closeLoanUseCase.close(loan);
    }

    @Override
    public Loan create(Loan loan) {
        return createLoanUseCase.create(loan);
    }

    @Override
    public List<Loan> getAllOverdue(String productType) {
        return getAllOverdueLoansUseCase.getAllOverdue(productType);
    }

    @Override
    public Loan getLoanById(String productType, UUID id) {
        return getLoanUseCase.getLoanById(productType, id);
    }
}
