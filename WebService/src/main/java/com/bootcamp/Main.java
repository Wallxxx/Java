package com.bootcamp;

import com.bootcamp.dao.CreateTables;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        CreateTables startDb = new CreateTables();
        startDb.createTables();
        startDb.insertTables();
        SpringApplication.run(Main.class);
    }
}
