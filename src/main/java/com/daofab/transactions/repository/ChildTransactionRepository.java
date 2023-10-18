package com.daofab.transactions.repository;

import com.daofab.transactions.model.ChildTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and managing ChildTransaction
 * entities in the database.
 * It extends JpaRepository to provide common CRUD operations.
 */
@Repository
public interface ChildTransactionRepository extends JpaRepository<ChildTransaction, Long> {

    /**
     * Custom query method using JPQL to find child transactions by parent ID.
     *
     * @param parentId The ID of the parent transaction to filter child transactions.
     * @param pageable Pageable object for pagination and sorting.
     * @return Page of ChildTransaction entities filtered by parent ID.
     */
    @Query("SELECT c FROM ChildTransaction c WHERE c.parentId = :parentId")
    Page<ChildTransaction> findByParentId(Long parentId, Pageable pageable);
}
