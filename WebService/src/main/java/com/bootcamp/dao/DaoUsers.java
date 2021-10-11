package com.bootcamp.dao;

import com.bootcamp.tables.Accounts;
import com.bootcamp.tables.Cards;
import com.bootcamp.tables.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

public class DaoUsers {
    private SessionFactory session;

    public DaoUsers() {
        try {
            Configuration config = new Configuration().configure();
            config.addAnnotatedClass(Users.class).addAnnotatedClass(Accounts.class).addAnnotatedClass(Cards.class); // City.class
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(config.getProperties());
            session = config.buildSessionFactory(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public Users getById(Integer id) {
        try (Session getSession = session.openSession()) {
            Users user = getSession.get(Users.class, id);
           // List<Users> temp = getSession.createSQLQuery("select * from Users where id = " + id).getResultList();
            return user;
        }
    }

    public List getByName(String name) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Users where name = " + name).getResultList();
        }
    }

    public List getBySurname(String surname) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Users where surname = " + surname).getResultList();
        }
    }

    public List getByPatronymic(String patronymic) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Users where patronymic = " + patronymic).getResultList();
        }
    }

    public List getByAge(Long age) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Users where age = " + age).getResultList();
        }
    }

    public List getByPhone(String phone) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Users where phone = " + phone).getResultList();
        }
    }

    public List getByAddress(String address) {
        try (Session getSession = session.openSession()) {
            return getSession.createSQLQuery("select * from Users where address = " + address).getResultList();
        }
    }

    public List getAll() {
        try (Session getSession = session.openSession()) {
            System.out.println("Session successful");
            return getSession.createSQLQuery("select * from Users").getResultList();
        }
    }

    @Transactional
    public void save(Users user) {
        try (Session saveSession = session.openSession()) {
            try {
                //saveSession.getTransaction();
                saveSession.save(user);
                //saveSession.getTransaction().commit();
            } catch (ConstraintViolationException e) {
                e.printStackTrace();
                //saveSession.getTransaction().rollback();
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        try (Session saveSession = session.openSession()) {
            try {
                //saveSession.getTransaction();
                saveSession.delete(getById(id));
                //saveSession.getTransaction().commit();
            } catch (ConstraintViolationException e) {
                e.printStackTrace();
                //saveSession.getTransaction().rollback();
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
