package com.bootcamp.connection;

import com.bootcamp.model.Accounts;
import com.bootcamp.model.Cards;
import com.bootcamp.model.Users;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ConnectionFactory implements ConnectionFactoryInterface{
    private static ConnectionFactory factory;

    private SessionFactory sessionFactory;

    private ConnectionFactory() {
        try {
            Configuration config = new Configuration().configure();
            config.addAnnotatedClass(Users.class).addAnnotatedClass(Accounts.class).addAnnotatedClass(Cards.class);
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(config.getProperties());
            sessionFactory = config.buildSessionFactory(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static ConnectionFactory getInstance() {
        ConnectionFactory result = factory;
        if (result != null) {
            return result;
        }
        synchronized(ConnectionFactory.class) {
            if (factory == null) {
                factory = new ConnectionFactory();
            }
            return factory;
        }
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
