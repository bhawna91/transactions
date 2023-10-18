package com.daofab.transactions.repository;

import com.daofab.transactions.model.ParentTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and managing ParentTransaction
 * entities in the database.
 * It extends JpaRepository to provide common CRUD operations.
 */
@Repository
public interface ParentTransactionRepository extends JpaRepository<ParentTransaction, Long> {

    /**
     * Custom query method to retrieve all parent transactions with pagination and sorting.
     *
     * @param pageable Pageable object for pagination and sorting.
     * @return Page of ParentTransaction entities with pagination and sorting applied.
     */
    Page<ParentTransaction> findAllBy(Pageable pageable);
}
