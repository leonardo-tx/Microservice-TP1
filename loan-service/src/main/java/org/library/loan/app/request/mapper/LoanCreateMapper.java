package org.library.loan.app.request.mapper;

import org.library.loan.app.request.dto.LoanCreateDTO;
import org.library.loan.core.model.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanCreateMapper {
    public Loan toModel(LoanCreateDTO entity) {
        return new Loan(
                null,
                entity.getProductId(),
                entity.getProductType(),
                null,
                entity.getDueDate(),
                null
        );
    }
}
