package com.daofab.transactions.controller;

import com.daofab.transactions.service.ParentTransactionService;
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
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import static org.mockito.Mockito.when;
import com.daofab.transactions.model.ParentTransaction;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ParentTransactionService parentTransactionService;

    @Test
    public void testDisplayParentTransactionList() throws Exception {
        // Create a sample Page object
        Page<ParentTransaction> page = new PageImpl<>(Collections.singletonList(
                new ParentTransaction(1L, "Sender", "Receiver", 100.0, 50.0)
        ));

        // Mock the service method to return the sample Page
        when(parentTransactionService.fetchParentTransactionList(PageRequest.of(0, 2)))
                .thenReturn(page);

        // Perform the test by making a request to the controller endpoint
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/transactions/parent/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }
}
