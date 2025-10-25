package org.library.loan.infra.adapter.persistence.repository;

import org.library.loan.infra.adapter.persistence.entity.LoanJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface LoanJpaRepository extends JpaRepository<LoanJpa, UUID> {
    @Query("""
        SELECT l FROM Loan l
        WHERE l.returnedDate IS NULL AND l.dueDate < :now
    """)
    List<LoanJpa> findAllOverdue(LocalDate now);
}
