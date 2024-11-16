package com.mfedorec.astonhomework.homework1.library.model;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private final String name;
    private List<Book> borrowedBooks = new ArrayList<>();
    private boolean blacklisted = false;

    public Reader(String name) {
        this.name = name;
    }

    public void placeOrder(Book book) {
        borrowedBooks.add(book);
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        this.blacklisted = blacklisted;
    }
}