package com.main.library_management.dao;

import com.main.library_management.models.Borrow;
import com.main.library_management.models.Document;
import com.main.library_management.models.User;

import java.util.List;

public interface IBorrowDAO {
    public void borrowBook(Document document, User user);
    public void returnBook(Document document, User user);
    public List<Borrow> getBorrows();
    public Borrow getBorrowByUserAndDocument(User user, Document document);


}
