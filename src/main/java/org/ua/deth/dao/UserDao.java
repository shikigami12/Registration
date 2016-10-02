package org.ua.deth.dao;


import org.hibernate.SessionFactory;
import org.ua.deth.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDao {
    private SessionFactory factory;
    private EntityManager entityManager;
    protected UserDao(SessionFactory factory) {
        this.factory = factory;

        entityManager = factory.createEntityManager();
    }

    public User getUserByLoginAndPassword(String login, String password){

        entityManager.getTransaction().begin();
        User user = entityManager.createQuery("select u from org.ua.deth.entity.User u " +
                "where u.login = :login " +
                "and u.password = :password", User.class)
                .setParameter("login", login)
                .setParameter("password", password).getResultList().get(0);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    public List<User> getAll(){
        //EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery("from org.ua.deth.entity.User ", User.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }

    public void createUser(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
