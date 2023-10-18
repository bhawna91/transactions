package com.daofab.transactions.service;

import com.daofab.transactions.model.ChildTransaction;
import com.daofab.transactions.repository.ChildTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service implementation class for managing ChildTransaction entities.
 * Implements methods for fetching child transactions from the database.
 */
@Service
public class ChildTransactionServiceImpl implements ChildTransactionService{
    @Autowired
    private ChildTransactionRepository childTransactionRepository;

    public List<ChildTransaction> fetchChildTransactionList() {
        return childTransactionRepository.findAll();
    }

    public ChildTransaction fetchChildTransactionById(Long ChildTransactionId) {
        return childTransactionRepository.findById(ChildTransactionId).get();
    }
}
