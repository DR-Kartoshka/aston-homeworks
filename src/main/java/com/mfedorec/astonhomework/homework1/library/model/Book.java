package com.mfedorec.astonhomework.homework1.library.model;


import java.util.Date;
import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private Date issueDate;
    private IssueType issueType;
    private Reader issuedTo;

    public enum IssueType {
        HOME, READING_ROOM
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public Reader getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(Reader issuedTo) {
        this.issuedTo = issuedTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
