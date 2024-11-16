package com.mfedorec.astonhomework.homework1.library.model;

import java.util.Date;

public class Librarian {
    private final String name;

    public Librarian(String name) {
        this.name = name;
    }

    public void issueBook(Reader reader, Book book, Date issueDate) {
        book.setIssueDate(issueDate);
        book.setIssueType(Book.IssueType.HOME);
        book.setIssuedTo(reader);
        reader.placeOrder(book);
        System.out.println("Читатель " + reader.getName() + " взял книгу " + book.getTitle() + " автора " + book.getAuthor() + " на дом. \n" + "Книгу выдал: " + name);
    }

    public void issueBook(Reader reader, Book book) {
        book.setIssueType(Book.IssueType.READING_ROOM);
        book.setIssuedTo(reader);
        reader.placeOrder(book);

        System.out.println("Читатель " + reader.getName() + " взял книгу " + book.getTitle() + " автора " + book.getAuthor() + " в читальный зал. \n" + "Книгу выдал: " + name);
    }

    public String getName() {
        return name;
    }
}