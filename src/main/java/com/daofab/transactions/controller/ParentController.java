package com.daofab.transactions.controller;

import com.daofab.transactions.model.ChildTransaction;
import com.daofab.transactions.model.ParentTransaction;
import com.daofab.transactions.service.ParentTransactionService;
import com.daofab.transactions.utils.SortOnlyPageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class responsible for handling HTTP requests
 * related to parent transactions.
 * It defines endpoints to retrieve parent transaction data.
 */
@Controller
@RequestMapping("/api/transactions/parent")
public class ParentController {

    @Autowired
    private ParentTransactionService parentTransactionService;

    private final Logger LOGGER = LoggerFactory.getLogger(ParentController.class);

    public ParentController(ParentTransactionService mockService) {
    }

    // Method to display a list of parent transactions
    @GetMapping("/all")
    public String displayParentTransactionList(Model model,
                                               @RequestParam(name = "page", defaultValue = "0") int page,
                                               @RequestParam(name = "sort", required = false, defaultValue = "asc") String sortField) {
        LOGGER.info("Inside displayParentTransactionList of ParentController");

        // Initialize sorting
        Sort sort = null;

        // Check if sorting is requested in descending order
        if ("desc".equalsIgnoreCase(sortField)) {
            sort = Sort.by(Sort.Order.desc("id"));
        } else {
            sort = Sort.by(Sort.Order.asc("id"));
        }

        // Create a PageRequest for pagination
        PageRequest pageable = PageRequest.of(page, 2, sort);

        // Fetch parent transactions using the service
        Page<ParentTransaction> parentTransactions = parentTransactionService.fetchParentTransactionList(pageable);

        // Add the transactions and sort information to the model
        model.addAttribute("transactions", parentTransactions);
        model.addAttribute("sort", sortField);

        // Return the name of the view template
        return "parent-transactions";
    }

    // Method to fetch child transactions by parent transaction ID
    @GetMapping("/{id}/child")
    public String fetchChildTransactionsByParentId(@PathVariable("id") Long parentTransactionId, Model model,
                                                   @RequestParam(name = "sort", required = false, defaultValue = "asc") String sortField) {
        LOGGER.info("Inside fetchChildTransactionsByParentId of ParentController");

        // Initialize sorting
        Sort sort = null;

        // Check if sorting is requested in descending order
        if ("desc".equalsIgnoreCase(sortField)) {
            sort = Sort.by(Sort.Order.desc("id"));
        } else {
            sort = Sort.by(Sort.Order.asc("id"));
        }

        // Create a pageable object for sorting
        Pageable pageable = new SortOnlyPageable(sort);

        // Fetch child transactions by parent transaction ID using the service
        Page<ChildTransaction> childTransactions = parentTransactionService.fetchChildDataByParentId(pageable, parentTransactionId);

        // Add the transactions and sort information to the model
        model.addAttribute("transactions", childTransactions);
        model.addAttribute("sort", sort);

        // Return the name of the view template
        return "child-transactions";
    }
}
