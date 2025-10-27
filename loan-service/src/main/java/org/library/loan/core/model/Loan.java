package org.library.loan.core.model;

import lombok.Getter;
import org.library.loan.core.exception.CoreException;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public final class Loan {
    private final UUID id;
    private final String productId;
    private final String productType;
    private final LocalDate createdDate;
    private final LocalDate dueDate;
    private LocalDate returnedDate;

    public Loan(UUID id, String productId, String productType, LocalDate createdDate, LocalDate dueDate, LocalDate returnedDate) {
        if (productId == null) {
            throw new CoreException("loan.product.id.null", "The product id cannot be null.");
        }
        if (productType == null) {
            throw new CoreException("loan.product.type.null", "The product type cannot be null.");
        }
        if (createdDate == null) {
            createdDate = LocalDate.now();
        }
        if (dueDate == null) {
            throw new CoreException("loan.due.date.null", "The due date cannot be null.");
        }
        if (dueDate.isBefore(createdDate)) {
            throw new CoreException("loan.due.date.invalid", "The due date cannot be before the created date.");
        }
        if (returnedDate != null && returnedDate.isBefore(createdDate)) {
            throw new CoreException("loan.returned.date.invalid", "The returned date cannot be before the created date.");
        }
        this.id = id;
        this.createdDate = createdDate;
        this.productId = productId;
        this.productType = productType;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
    }

    public void closeLoan() {
        if (returnedDate != null) {
            throw new CoreException("loan.already.closed", "The loan was already closed.");
        }
        returnedDate = LocalDate.now();
    }

    public LoanStatus verifyStatus() {
        LocalDate now = LocalDate.now();
        boolean overdue = now.isAfter(dueDate);
        if (returnedDate != null) {
            return overdue ? LoanStatus.RETURNED_WITH_OVERDUE : LoanStatus.RETURNED;
        }
        return overdue ? LoanStatus.OVERDUE : LoanStatus.CREATED;
    }
}
