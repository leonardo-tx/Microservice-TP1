package org.library.loan.infra.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.library.loan.core.model.Loan;
import org.library.loan.core.port.out.FindAllOverdueLoansPort;
import org.library.loan.infra.adapter.persistence.mapper.LoanMapper;
import org.library.loan.infra.adapter.persistence.repository.LoanJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllOverdueLoansAdapter implements FindAllOverdueLoansPort {
    private final LoanJpaRepository loanJpaRepository;
    private final LoanMapper loanMapper;

    @Override
    public List<Loan> findAllOverdue(String productType) {
        LocalDate now = LocalDate.now();
        if (productType == null) {
            return loanJpaRepository.findAllOverdue(now)
                    .stream()
                    .map(loanMapper::toModel)
                    .toList();
        }
        return loanJpaRepository.findAllOverdueByProductType(productType, now)
                .stream()
                .map(loanMapper::toModel)
                .toList();
    }
}
