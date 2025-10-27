package org.library.loan.infra.adapter.persistence.repository;

import org.library.loan.infra.adapter.persistence.entity.LoanJpa;
import org.library.loan.infra.adapter.persistence.entity.LoanJpaIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface LoanJpaRepository extends JpaRepository<LoanJpa, LoanJpaIdentifier> {
    @Query("""
        SELECT l FROM Loan l
        WHERE l.returnedDate IS NULL AND l.dueDate < :now
    """)
    List<LoanJpa> findAllOverdue(LocalDate now);

    @Query("""
        SELECT l FROM Loan l
        WHERE l.id.productType = :productType AND l.returnedDate IS NULL AND l.dueDate < :now
    """)
    List<LoanJpa> findAllOverdueByProductType(String productType, LocalDate now);
}
