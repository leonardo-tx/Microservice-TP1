package org.library.loan.core.service;

import lombok.RequiredArgsConstructor;
import org.library.loan.core.model.Loan;
import org.library.loan.core.port.in.CloseLoanUseCase;
import org.library.loan.core.port.out.SaveLoanPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CloseLoanService implements CloseLoanUseCase {
    private final SaveLoanPort saveLoanPort;

    @Override
    public Loan close(Loan loan) {
        loan.closeLoan();
        return saveLoanPort.save(loan);
    }
}
