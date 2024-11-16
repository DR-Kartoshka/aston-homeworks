package com.mfedorec.astonhomework.homework1.library.logic;

import com.mfedorec.astonhomework.homework1.library.model.Book;
import com.mfedorec.astonhomework.homework1.library.model.Reader;

import java.util.ArrayList;
import java.util.List;

public class Administrator {
    private static List<Book> catalog = new ArrayList<>();

    public void addBook(Book book) {
        catalog.add(book);
    }

    public boolean searchCatalog(Book book) {
        return catalog.contains(book);
    }

    public void addToBlacklist(Reader reader) {
        reader.setBlacklisted(true);
        System.out.println("Читатель " + reader.getName() + " добавлен в черный список.");
    }
}