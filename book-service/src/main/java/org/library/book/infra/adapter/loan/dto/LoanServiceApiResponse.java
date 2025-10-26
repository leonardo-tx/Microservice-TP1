package org.library.book.infra.adapter.loan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class LoanServiceApiResponse<T> {
    private boolean success;
    private T result;
    private LoanServiceErrorData error;
}
