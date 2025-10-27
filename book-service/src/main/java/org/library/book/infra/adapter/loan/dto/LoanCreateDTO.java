package org.library.book.infra.adapter.loan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanCreateDTO {
    private String productId;
    private String productType;
    private LocalDate dueDate;
}
