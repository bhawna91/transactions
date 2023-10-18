package com.daofab.transactions.controller;

import com.daofab.transactions.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Controller class responsible for managing transaction-related HTTP requests.
 * It defines an endpoint to load all transactions from json files.
 */
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final Logger LOGGER =
            LoggerFactory.getLogger(TransactionController.class);

    // Service for handling transactions
    @Autowired
    private TransactionService transactionService;

    // Endpoint for loading all transactions
    @GetMapping("/loadAllTransactions")
    // Set the HTTP response status to OK (200) when transactions are loaded
    @ResponseStatus(HttpStatus.OK)
    public void loadAllTransactions() throws IOException {
        LOGGER.info("Inside loadAllTransactions of TransactionController");

        // Call the transaction service to load all transactions from json files
        transactionService.loadAllTransactions();
    }
}
