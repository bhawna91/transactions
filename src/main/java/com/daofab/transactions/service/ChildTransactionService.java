package com.daofab.transactions.service;

import com.daofab.transactions.model.ChildTransaction;

import java.util.List;

/**
 * Service interface for managing ChildTransaction entities.
 * Defines methods for fetching child transactions from the database.
 */
public interface ChildTransactionService {

    /**
     * Retrieves a list of all child transactions.
     *
     * @return List of ChildTransaction entities.
     */
    List<ChildTransaction> fetchChildTransactionList();

    /**
     * Retrieves a specific child transaction by its ID.
     *
     * @param childTransactionId The ID of the child transaction to retrieve.
     * @return The ChildTransaction entity with the specified ID.
     */
    ChildTransaction fetchChildTransactionById(Long childTransactionId);
}
