package com.main.library_management.dao;

import com.main.library_management.models.Document;

import java.util.List;

public interface IDocumentDAO {
    public List<Document> getAllDocuments();
    public void addDocument(Document document);
}
