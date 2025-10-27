package org.library.loan.infra.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Loan")
@Table(name = "loans")
public class LoanJpa {
    @EmbeddedId
    private LoanJpaIdentifier id;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "returned_date", nullable = true)
    private LocalDate returnedDate;
}
