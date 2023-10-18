package com.daofab.transactions.service;

import com.daofab.transactions.model.ParentTransaction;
import com.daofab.transactions.repository.ParentTransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
@SpringBootTest
public class ParentTransactionServiceTest {

    @Autowired
    private ParentTransactionServiceImpl parentTransactionService; // Use the actual implementation

    @MockBean
    private ParentTransactionRepository parentTransactionRepository;

    @Test
    public void testFetchParentTransactionList() {
        List<ParentTransaction> parentTransactions = new ArrayList<>();
        parentTransactions.add(new ParentTransaction(1L, "Sender1", "Receiver1", 100.0, 50.0));
        parentTransactions.add(new ParentTransaction(2L, "Sender2", "Receiver2", 200.0, 75.0));

        Page<ParentTransaction> page = new PageImpl<>(parentTransactions);

        when(parentTransactionRepository.findAllBy(Mockito.any(Pageable.class))).thenReturn(page);

        Page<ParentTransaction> fetchedParentTransactions = parentTransactionService.fetchParentTransactionList(Pageable.unpaged());

        assertThat(fetchedParentTransactions).isNotNull();
        assertThat(fetchedParentTransactions.getContent()).hasSize(2);
    }
}
