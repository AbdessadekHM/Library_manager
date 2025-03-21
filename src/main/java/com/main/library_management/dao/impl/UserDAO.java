package com.main.library_management.dao.impl;

import com.main.library_management.dao.IUserDAO;
import com.main.library_management.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO implements IUserDAO {
    private static UserDAO instance;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_management");
    private final EntityManager em = emf.createEntityManager();

    private UserDAO() {}
    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }



    @Override
    public void addUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
}
