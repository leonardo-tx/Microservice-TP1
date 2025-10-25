package org.library.loan.app.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.library.loan.core.model.LoanStatus;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanViewDTO {
    private UUID id;
    private String productId;
    private LocalDate createdDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;
    private LoanStatus status;
}
