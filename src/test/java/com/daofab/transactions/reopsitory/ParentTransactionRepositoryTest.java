package com.daofab.transactions.reopsitory;

import com.daofab.transactions.model.ParentTransaction;
import com.daofab.transactions.repository.ParentTransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ParentTransactionRepositoryTest {

    @Autowired
    private ParentTransactionRepository parentTransactionRepository;

    @Test
    public void testSaveAndFindById() {
        // Create a sample ParentTransaction
        ParentTransaction parentTransaction = new ParentTransaction();
        parentTransaction.setSender("Sender");
        parentTransaction.setReceiver("Receiver");
        parentTransaction.setTotalAmount(100.0);
        parentTransaction.setTotalPaidAmount(50.0);

        // Save the ParentTransaction
        parentTransactionRepository.save(parentTransaction);

        // Find the saved ParentTransaction by ID
        ParentTransaction foundTransaction = parentTransactionRepository.findById(parentTransaction.getId()).orElse(null);

        // Assert that the saved and retrieved transactions are equal
        assertThat(foundTransaction).isEqualTo(parentTransaction);
    }
}
