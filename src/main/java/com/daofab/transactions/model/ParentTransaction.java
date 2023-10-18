package com.daofab.transactions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Represents a Parent Transaction entity in the database.
 * This class is annotated with JPA annotations for entity mapping.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sender;
    private String receiver;
    private Double totalAmount;
    private Double totalPaidAmount;
}
