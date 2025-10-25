package org.library.loan.infra.adapter.persistence.mapper;

import org.library.loan.core.model.Loan;
import org.library.loan.infra.adapter.persistence.entity.LoanJpa;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    public Loan toModel(LoanJpa entity) {
        return new Loan(
                entity.getId(),
                entity.getProductId(),
                entity.getCreatedDate(),
                entity.getDueDate(),
                entity.getReturnedDate()
        );
    }

    public LoanJpa toEntity(Loan model) {
        return LoanJpa.builder()
                .id(model.getId())
                .productId(model.getProductId())
                .createdDate(model.getCreatedDate())
                .dueDate(model.getDueDate())
                .returnedDate(model.getReturnedDate())
                .build();
    }
}
