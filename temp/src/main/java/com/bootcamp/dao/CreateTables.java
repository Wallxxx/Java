package com.bootcamp.dao;

import com.bootcamp.connection.ConnectionFactory;
import org.hibernate.Session;

import javax.persistence.PersistenceException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateTables implements FillingInterface {
    private final String tablesPath = "src/main/resources/db/tables.sql";
    private final String insertsPath = "src/main/resources/db/inserts.sql";
    private ConnectionFactory connectionFactory;

    public CreateTables() {
        connectionFactory = ConnectionFactory.getInstance();
    }

    @Override
    public void createTables() {
        execute(tablesPath);
    }

    @Override
    public void insertTables() {
        execute(insertsPath);
    }

    private void execute(String path) {
        try {
            String script = new String(Files.readAllBytes(Paths.get(path)));
            try (Session session = connectionFactory.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.createNativeQuery(script).executeUpdate();
                session.getTransaction().commit();
            } catch (PersistenceException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
