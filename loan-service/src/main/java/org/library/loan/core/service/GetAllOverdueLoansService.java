package org.library.loan.core.service;

import lombok.RequiredArgsConstructor;
import org.library.loan.core.model.Loan;
import org.library.loan.core.port.in.GetAllOverdueLoansUseCase;
import org.library.loan.core.port.out.FindAllOverdueLoansPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllOverdueLoansService implements GetAllOverdueLoansUseCase {
    private final FindAllOverdueLoansPort findAllOverdueLoansPort;

    @Override
    public List<Loan> getAllOverdue(String productType) {
        return findAllOverdueLoansPort.findAllOverdue(productType);
    }
}
