package org.library.book.infra.adapter.loan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class LoanServiceErrorData {
    private String code;
    private String message;
}
