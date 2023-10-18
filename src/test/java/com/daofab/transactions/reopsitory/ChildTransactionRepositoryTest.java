package com.daofab.transactions.reopsitory;

import com.daofab.transactions.model.ChildTransaction;
import com.daofab.transactions.repository.ChildTransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ChildTransactionRepositoryTest {

    @Autowired
    private ChildTransactionRepository childTransactionRepository;

    @Test
    public void testSaveAndFindById() {
        // Create a sample ChildTransaction
        ChildTransaction childTransaction = new ChildTransaction();
        childTransaction.setParentId(1L);
        childTransaction.setPaidAmount(50.0);
        childTransaction.setSender("Sender");
        childTransaction.setReceiver("Receiver");
        childTransaction.setTotalAmount(100.0);

        // Save the ChildTransaction
        childTransactionRepository.save(childTransaction);

        // Find the saved ChildTransaction by ID
        ChildTransaction foundTransaction = childTransactionRepository.findById(childTransaction.getId()).orElse(null);

        // Assert that the saved and retrieved transactions are equal
        assertThat(foundTransaction).isEqualTo(childTransaction);
    }
}
