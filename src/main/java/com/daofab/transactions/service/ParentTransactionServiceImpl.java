package com.daofab.transactions.service;

import com.daofab.transactions.model.ChildTransaction;
import com.daofab.transactions.model.ParentTransaction;
import com.daofab.transactions.repository.ChildTransactionRepository;
import com.daofab.transactions.repository.ParentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service implementation class for managing ParentTransaction
 * entities and related operations.
 * Implements methods for fetching parent transactions
 * and associated child transactions.
 */
@Service
public class ParentTransactionServiceImpl implements ParentTransactionService {
    @Autowired
    private ParentTransactionRepository parentTransactionRepository;

    @Autowired
    private ChildTransactionRepository childTransactionRepository;

    public Page<ParentTransaction> fetchParentTransactionList(Pageable pageable) {
        return parentTransactionRepository.findAllBy(pageable);
    }

    public Page<ChildTransaction> fetchChildDataByParentId(Pageable pageable, Long parentTransactionId) {
        return childTransactionRepository.findByParentId(parentTransactionId, pageable);
    }
}