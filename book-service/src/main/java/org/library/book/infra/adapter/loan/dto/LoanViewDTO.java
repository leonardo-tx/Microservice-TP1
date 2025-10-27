package org.library.book.infra.adapter.loan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanViewDTO {
    private UUID id;
    private String productId;
    private String productType;
    private LocalDate createdDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;
    private String status;
}
