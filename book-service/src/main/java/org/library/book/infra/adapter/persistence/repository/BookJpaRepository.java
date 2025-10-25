package org.library.book.infra.adapter.persistence.repository;

import org.library.book.infra.adapter.persistence.entity.BookJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<BookJpa, String> {
}
