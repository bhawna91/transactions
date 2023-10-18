package com.daofab.transactions.service;

import com.daofab.transactions.model.ChildTransaction;
import com.daofab.transactions.repository.ChildTransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ChildTransactionServiceTest {

    @Autowired
    private ChildTransactionServiceImpl childTransactionService;

    @MockBean
    private ChildTransactionRepository childTransactionRepository;

    @BeforeEach
    void setUp() {
        // Create a sample ChildTransaction
        ChildTransaction childTransaction = new ChildTransaction();
        childTransaction.setId(1L);
        childTransaction.setParentId(1L);
        childTransaction.setSender("Sender1");
        childTransaction.setReceiver("Receiver1");
        childTransaction.setTotalAmount(50.0);
        childTransaction.setPaidAmount(50.0);
        Mockito.when(childTransactionRepository.findById(1L))
                .thenReturn(Optional.of(childTransaction));
    }

    @Test
    public void testFetchChildTransactionList() {
        ChildTransaction childTransaction = childTransactionService.fetchChildTransactionById(1L);

        assertEquals("Sender1", childTransaction.getSender());
        assertEquals("Receiver1", childTransaction.getReceiver());
        assertEquals(1L, childTransaction.getId());
        assertEquals(1L, childTransaction.getParentId());
        assertEquals(50.0, childTransaction.getPaidAmount());
        assertEquals(50.0, childTransaction.getTotalAmount());
    }
}
