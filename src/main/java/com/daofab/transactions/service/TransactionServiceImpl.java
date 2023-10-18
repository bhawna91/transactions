package com.daofab.transactions.service;

import com.daofab.transactions.model.ChildTransaction;
import com.daofab.transactions.model.ParentTransaction;
import com.daofab.transactions.repository.ChildTransactionRepository;
import com.daofab.transactions.repository.ParentTransactionRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Service implementation class for loading
 * transactions into the system.
 * Implements the method to load all transactions,
 * typically from external JSON files.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    public static final String PARENT_JSON = "src/main/resources/Parent.json";
    public static final String CHILD_JSON = "src/main/resources/Child.json";
    @Autowired
    private ParentTransactionRepository parentTransactionRepository;

    @Autowired
    private ChildTransactionRepository childTransactionRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    //Loads all transactions from JSON files into the system
    public void loadAllTransactions() throws IOException {
        List<ParentTransaction> parentTransactions = loadParentTransactions();
        List<ChildTransaction> childTransactions = loadChildTransactions();
        calculateTotalPaidAmount(parentTransactions, childTransactions);
        populateChildTransactionData(parentTransactions, childTransactions);
        saveTransactionsToDatabase(parentTransactions, childTransactions);
    }

    private List<ParentTransaction> loadParentTransactions() throws IOException {
        JsonNode parentRootNode = objectMapper.readTree(new File(PARENT_JSON));
        JsonNode parentDataArray = parentRootNode.get("data");
        if (parentDataArray != null && parentDataArray.isArray()) {

            //Returns parent transactions from the Parent.json file
            return objectMapper.readValue(
                    parentDataArray.toString(), new TypeReference<>() {
                    });
        }
        return new ArrayList<>();
    }

    private List<ChildTransaction> loadChildTransactions() throws IOException {
        JsonNode childRootNode = objectMapper.readTree(new File(CHILD_JSON));
        JsonNode childDataArray = childRootNode.get("data");
        if (childDataArray != null && childDataArray.isArray()) {

            //Returns child transactions from the Child.json file
            return objectMapper.readValue(
                    childDataArray.toString(), new TypeReference<>() {
                    });
        }
        return new ArrayList<>();
    }

    private void calculateTotalPaidAmount(List<ParentTransaction> parentTransactions, List<ChildTransaction> childTransactions) {
        for (ParentTransaction parent : parentTransactions) {
            Long parentId = parent.getId();

            //Calculates the total paid amount for each Parent transaction from child transactions
            Double totalPaidAmount = childTransactions.stream()
                    .filter(child -> Objects.equals(child.getParentId(), parentId))
                    .mapToDouble(ChildTransaction::getPaidAmount)
                    .sum();
            parent.setTotalPaidAmount(totalPaidAmount);
        }
    }

    private void populateChildTransactionData(List<ParentTransaction> parentTransactions, List<ChildTransaction> childTransactions) {
        for (ChildTransaction child : childTransactions) {
            Long parentId = child.getParentId();

            // Populates child transaction data based on the corresponding parent transaction
            ParentTransaction parentTransaction = parentTransactions.stream()
                    .filter(parent -> Objects.equals(parent.getId(), parentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Parent transaction not found"));

            child.setSender(parentTransaction.getSender());
            child.setReceiver(parentTransaction.getReceiver());
            child.setTotalAmount(parentTransaction.getTotalAmount());
        }
    }

    //Saves parent and child transactions to the database
    private void saveTransactionsToDatabase(List<ParentTransaction> parentTransactions, List<ChildTransaction> childTransactions) {
        parentTransactionRepository.saveAll(parentTransactions);
        childTransactionRepository.saveAll(childTransactions);
    }
}
