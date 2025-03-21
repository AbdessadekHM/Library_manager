package com.main.library_management.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "books")
public class Book extends Document {

    private String author;
    private String isbbn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datePublishion;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbbn() {
        return isbbn;
    }

    public void setIsbbn(String isbbn) {
        this.isbbn = isbbn;
    }

    public Date getDatePublishion() {
        return datePublishion;
    }

    public void setDatePublishion(Date datePublishion) {
        this.datePublishion = datePublishion;
    }
}
