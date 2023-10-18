package com.daofab.transactions.controller;

import com.daofab.transactions.model.ChildTransaction;
import com.daofab.transactions.service.ChildTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class responsible for handling HTTP requests
 * related to child transactions.
 * It defines endpoints to retrieve child transaction data.
 */
@RestController
@RequestMapping("/api/transactions/child")
public class ChildController {

    @Autowired
    private ChildTransactionService childTransactionService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(ChildController.class);


    @GetMapping("/all")
    public List<ChildTransaction> fetchChildTransactionList() {
        LOGGER.info("Inside fetchChildTransactionList of ChildController");
        return childTransactionService.fetchChildTransactionList();
    }

    @GetMapping("/{id}")
    public ChildTransaction fetchChildTransactionById(@PathVariable("id") Long childTransactionId) {
        LOGGER.info("Inside fetchChildTransactionById of ChildController");
        return childTransactionService.fetchChildTransactionById(childTransactionId);
    }
}
