package org.library.loan.core.service;

import lombok.RequiredArgsConstructor;
import org.library.loan.core.model.Loan;
import org.library.loan.core.port.in.CreateLoanUseCase;
import org.library.loan.core.port.out.SaveLoanPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateLoanService implements CreateLoanUseCase {
    private final SaveLoanPort saveLoanPort;

    @Override
    public Loan create(Loan loan) {
        return saveLoanPort.save(loan);
    }
}
