package com.bootcamp.integration;

import com.bootcamp.controllers.ControllerCards;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
public class ControllerCardsTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ControllerCards controllerCards;

    @Test
    public void controllerCardsTesting () {
        Assertions.assertThat(controllerCards).isNotNull();
    }

    @Test
    public void getCardsByUserIdTestPass() throws Exception {
        mockMvc.perform(get("/api/cards/getCardsByUserId/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"number\": \"1274 0000 5555 0001\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"number\": \"1274 0000 5555 0002\"\n" +
                "    }\n" +
                "]"));
    }

    @Test
    public void getCardsByUserIdTestFail() throws Exception {
        mockMvc.perform(get("/api/cards/getCardsByUserId/FFF"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void newCardTestPass() throws Exception {
        mockMvc.perform(post("/api/cards/newCard/7908-0000"))
                .andExpect(status().isOk());
    }

    @Test
    public void getCountCardsByAccountTestPass() throws Exception {
        mockMvc.perform(get("/api/cards/count/7908-0000"))
                .andExpect(status().isOk())
                .andExpect(content().json("2"));
    }

    public void getCountCardsByAccountTestFail() throws Exception {
        mockMvc.perform(get("/api/cards/count/7008-0000"))
                .andExpect(status().isNotFound());
    }

}
