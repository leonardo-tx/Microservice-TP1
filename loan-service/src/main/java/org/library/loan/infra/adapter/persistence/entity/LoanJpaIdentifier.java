package org.library.loan.infra.adapter.persistence.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanJpaIdentifier implements Serializable {
    private UUID id;
    private String productType;
}
