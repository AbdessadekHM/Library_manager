package com.main.library_management.models;

import java.util.Date;

public class Magazine extends Document{
    private String publisher;
    private String issueNumber;
    private Date dateissue;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Date getDateissue() {
        return dateissue;
    }

    public void setDateissue(Date dateissue) {
        this.dateissue = dateissue;
    }
}
