package org.library.loan.infra.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.library.loan.core.model.Loan;
import org.library.loan.core.port.out.FindLoanPort;
import org.library.loan.infra.adapter.persistence.entity.LoanJpaIdentifier;
import org.library.loan.infra.adapter.persistence.mapper.LoanMapper;
import org.library.loan.infra.adapter.persistence.repository.LoanJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindLoanAdapter implements FindLoanPort {
    private final LoanJpaRepository loanJpaRepository;
    private final LoanMapper loanMapper;

    @Override
    public Optional<Loan> findById(String productType, UUID id) {
        LoanJpaIdentifier loanJpaIdentifier = new LoanJpaIdentifier(id, productType);
        return loanJpaRepository.findById(loanJpaIdentifier)
                .map(loanMapper::toModel);
    }
}
