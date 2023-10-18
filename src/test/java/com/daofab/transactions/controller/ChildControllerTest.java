package com.daofab.transactions.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Collections;
import java.util.List;

import org.mockito.Mock;
import static org.mockito.Mockito.when;
import com.daofab.transactions.model.ChildTransaction;
import com.daofab.transactions.service.ChildTransactionService;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ChildControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ChildTransactionService childTransactionService;

    @Test
    public void testDisplayChildTransactionList() throws Exception {
        // Create a sample list of child transactions
        List<ChildTransaction> childTransactions = Collections.singletonList(
                new ChildTransaction(1L, 1L, 50.0, "Sender", "Receiver", 100.0)
        );

        // Mock the service method to return the sample list of child transactions
        when(childTransactionService.fetchChildTransactionList())
                .thenReturn(childTransactions);

        // Perform the test by making a request to the controller endpoint
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/transactions/child/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}
