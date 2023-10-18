package com.daofab.transactions.service;

import java.io.IOException;

/**
 * Service interface for loading transactions into the system.
 * Provides a method to load all transactions from provided json files.
 */
public interface TransactionService {

    /**
     * Loads all transactions into the system.
     *
     * @throws IOException If there is an I/O error during the loading process.
     */
    public void loadAllTransactions() throws IOException;
}
