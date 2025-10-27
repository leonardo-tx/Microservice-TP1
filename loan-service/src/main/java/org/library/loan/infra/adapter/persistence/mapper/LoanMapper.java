package org.library.loan.infra.adapter.persistence.mapper;

import org.library.loan.core.model.Loan;
import org.library.loan.infra.adapter.persistence.entity.LoanJpa;
import org.library.loan.infra.adapter.persistence.entity.LoanJpaIdentifier;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    public Loan toModel(LoanJpa entity) {
        return new Loan(
                entity.getId().getId(),
                entity.getProductId(),
                entity.getId().getProductType(),
                entity.getCreatedDate(),
                entity.getDueDate(),
                entity.getReturnedDate()
        );
    }

    public LoanJpa toEntity(Loan model) {
        LoanJpaIdentifier id = new LoanJpaIdentifier(model.getId(), model.getProductType());
        return LoanJpa.builder()
                .id(id)
                .productId(model.getProductId())
                .createdDate(model.getCreatedDate())
                .dueDate(model.getDueDate())
                .returnedDate(model.getReturnedDate())
                .build();
    }
}
