package com.daofab.transactions.service;

import com.daofab.transactions.model.ChildTransaction;
import com.daofab.transactions.model.ParentTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service interface for managing ParentTransaction
 * entities and related operations.
 * Provides methods for fetching parent transactions
 * and associated child transactions.
 */
public interface ParentTransactionService {

    /**
     * Retrieves a paginated list of parent transactions from the database.
     *
     * @param pageable Pageable object for pagination and sorting.
     * @return Page of ParentTransaction entities with pagination and sorting applied.
     */
    Page<ParentTransaction> fetchParentTransactionList(Pageable pageable);

    /**
     * Retrieves child transactions associated with a specific parent transaction, with pagination.
     *
     * @param pageable            Pageable object for pagination and sorting.
     * @param parentTransactionId The ID of the parent transaction to retrieve child
     *                            transactions for.
     * @return Page of ChildTransaction entities associated with the specified
     * parent transaction.
     */
    Page<ChildTransaction> fetchChildDataByParentId(Pageable pageable, Long parentTransactionId);
}
