package com.main.library_management.dao.impl;

import com.main.library_management.dao.IDocumentDAO;
import com.main.library_management.models.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class DocumentDAO implements IDocumentDAO {
    private static DocumentDAO instance;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_management");
    private final EntityManager em = emf.createEntityManager();




    private DocumentDAO() {}
    public static DocumentDAO getInstance() {
        if (instance == null) {
            instance = new DocumentDAO();
        }
        return instance;
    }

    @Override
    public List<Document> getAllDocuments() {
        Query query = em.createQuery("SELECT d FROM Document d");
        return query.getResultList();
    }

    @Override
    public void addDocument(Document document) {
        em.getTransaction().begin();
        em.persist(document);
        em.getTransaction().commit();
    }
}
