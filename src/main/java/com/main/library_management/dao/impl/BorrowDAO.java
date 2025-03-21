package com.main.library_management.dao.impl;

import com.main.library_management.dao.IBorrowDAO;
import com.main.library_management.models.Borrow;
import com.main.library_management.models.Document;
import com.main.library_management.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.Date;
import java.util.List;

public class BorrowDAO implements IBorrowDAO {
    private static BorrowDAO instance;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_management");
    private final EntityManager em = emf.createEntityManager();

    private BorrowDAO(){}


    public static BorrowDAO getInstance(){
        if(instance == null){
            instance = new BorrowDAO();
        }
        return instance;

    }
    @Override
    public void borrowBook(Document document, User user) {
        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setDocument(document);
        borrow.setDateBorrow(new Date());

        em.getTransaction().begin();
        em.persist(borrow);
        em.getTransaction().commit();


    }

    @Override
    public void returnBook(Document document, User user) {
        Borrow borrow = getBorrowByUserAndDocument(user, document);

        borrow.setDateReturn((new Date()));
        em.getTransaction().begin();
        em.persist(borrow);
        em.getTransaction().commit();



    }

    @Override
    public List<Borrow> getBorrows() {
        List<Borrow> borrows = null;
        Query query = em.createQuery("SELECT b FROM Borrow b");
        borrows = query.getResultList();
        return borrows;

    }

    @Override
    public Borrow getBorrowByUserAndDocument(User user, Document document) {


       Query query = em.createQuery("SELECT b FROM Borrow b WHERE b.user = :user AND b.document = :document") ;
       query.setParameter("user", user);
       query.setParameter("document", document);

       Borrow borrow = (Borrow) query.getSingleResult();

       return borrow;
    }

}
