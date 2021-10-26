package com.rest.integration;

import com.rest.controllers.CounterController;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CounterControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CounterController counterController;

    @Before
    public void load() {
        counterController.create("temp2");
        counterController.create("temp3");
        counterController.create("temp4");
    }

    @Test
    public void CounterControllerTest() {
        Assertions.assertThat(counterController).isNotNull();
    }

    @Test
    public void createTest() throws Exception {
        mockMvc.perform(post("/api/create/temp1"))
                .andExpect(status().isOk());
    }

    @Test
    public void incTest() throws Exception {
        mockMvc.perform(put("/api/inc/temp3"))
                .andExpect(status().isOk());
    }

    @Test
    public void getTest() throws Exception {
        mockMvc.perform(get("/api/get/temp2"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void getNotFoundTest() throws Exception {
        mockMvc.perform(get("/api/get/temp567"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteTest() throws Exception {
        mockMvc.perform(delete("/api/delete/temp4"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteNotFoundTest() throws Exception {
        mockMvc.perform(delete("/api/delete/temp234"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void sumTest() throws Exception {
        mockMvc.perform(get("/api/sum/"))
                .andExpect(status().isOk());
    }

    @Test
    public void showNamesTest() throws Exception {
        mockMvc.perform(get("/api/show/"))
                .andExpect(status().isOk());
    }

    @Test
    public void isHaveTest() throws Exception {
        mockMvc.perform(get("/api/have/temp2"))
                .andExpect(status().isFound());
    }

    @Test
    public void isHaveNotFoundTest() throws Exception {
        mockMvc.perform(get("/api/have/temp3332"))
                .andExpect(status().isNotFound());
    }
}
