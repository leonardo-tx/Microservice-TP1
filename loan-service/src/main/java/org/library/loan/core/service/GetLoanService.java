package org.library.loan.core.service;

import lombok.RequiredArgsConstructor;
import org.library.loan.core.exception.NotFoundException;
import org.library.loan.core.model.Loan;
import org.library.loan.core.port.in.GetLoanUseCase;
import org.library.loan.core.port.out.FindLoanPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetLoanService implements GetLoanUseCase {
    private final FindLoanPort findLoanPort;

    @Override
    public Loan getLoanById(String productType, UUID id) {
        return findLoanPort.findById(productType, id)
                .orElseThrow(() -> new NotFoundException("loan.not.found", "The loan was not found."));
    }
}
