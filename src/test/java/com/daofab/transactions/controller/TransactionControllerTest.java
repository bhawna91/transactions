package com.daofab.transactions.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.daofab.transactions.service.TransactionService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TransactionService transactionService;

    @Test
    public void testLoadAllTransactions() throws Exception {
        // Mock the service method to perform the void operation
        Mockito.doNothing().when(transactionService).loadAllTransactions();

        // Perform the test by making a request to the controller endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/api/transactions/loadAllTransactions"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
