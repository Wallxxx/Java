package com.bootcamp.connection;

import org.hibernate.SessionFactory;

public interface ConnectionFactoryInterface {
    SessionFactory getSessionFactory();
}
