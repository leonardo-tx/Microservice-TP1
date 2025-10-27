package org.library.loan.app.response.mapper;

import org.library.loan.app.response.dto.LoanViewDTO;
import org.library.loan.core.model.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanViewMapper {
    public LoanViewDTO toEntity(Loan model) {
        return LoanViewDTO.builder()
                .id(model.getId())
                .productId(model.getProductId())
                .productType(model.getProductType())
                .createdDate(model.getCreatedDate())
                .dueDate(model.getDueDate())
                .returnedDate(model.getReturnedDate())
                .status(model.verifyStatus())
                .build();
    }
}
