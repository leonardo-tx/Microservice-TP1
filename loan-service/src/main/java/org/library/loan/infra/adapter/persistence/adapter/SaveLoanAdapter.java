package org.library.loan.infra.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.library.loan.core.model.Loan;
import org.library.loan.core.port.out.SaveLoanPort;
import org.library.loan.infra.adapter.persistence.entity.LoanJpa;
import org.library.loan.infra.adapter.persistence.mapper.LoanMapper;
import org.library.loan.infra.adapter.persistence.repository.LoanJpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SaveLoanAdapter implements SaveLoanPort {
    private final LoanJpaRepository loanJpaRepository;
    private final LoanMapper loanMapper;

    @Override
    public Loan save(Loan loan) {
        LoanJpa entity = loanMapper.toEntity(loan);
        if (entity.getId().getId() == null) {
            entity.getId().setId(UUID.randomUUID());
        }
        LoanJpa savedEntity = loanJpaRepository.save(entity);
        return loanMapper.toModel(savedEntity);
    }
}
