package org.ua.deth.dao;


import org.hibernate.*;

import javax.persistence.*;

public class DaoFactory {

    private static DaoFactory ourInstance = new DaoFactory();
    private SessionFactory sessionFactory;
    private UserDao userDao;

    private DaoFactory() {
        sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("jpa");
    }

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao(sessionFactory);
        }
        return userDao;
    }
}
