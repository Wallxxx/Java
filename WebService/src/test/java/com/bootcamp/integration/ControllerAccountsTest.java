package com.bootcamp.integration;

import com.bootcamp.controllers.ControllerAccounts;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class ControllerAccountsTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ControllerAccounts controllerAccounts;

    @Test
    public void controllerCardsTesting () {
        Assertions.assertThat(controllerAccounts).isNotNull();
    }

    @Test
    public void getBalanceByUserIdTestPass() throws Exception {
        mockMvc.perform(get("/api/account/getBanalceByUserId/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"number\": \"7908-0000\",\n" +
                        "        \"balance\": 0\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void getBalanceByUserIdTestFail() throws Exception {
        mockMvc.perform(get("/api/account/getBanalceByUserId/F1"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getBalanceByAccountNumberTestPass() throws Exception {
        mockMvc.perform(get("/api/account/getBalanceByAccountNumber/7908-0000"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"number\": \"7908-0000\",\n" +
                        "    \"balance\": 0\n" +
                        "}"));
    }

    @Test
    public void getBalanceByAccountNumberTestFail() throws Exception {
        mockMvc.perform(get("/api/account/getBalanceByAccountNumber/7908/0056"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void addDepositTestPass() throws Exception {
        mockMvc.perform(put("/api/account/addDeposit/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n" +
                    "    \"number\": \"7908-0000\",\n" +
                    "    \"value\": 0\n" +
                    "}"))
                .andExpect(status().isOk());
    }
}
