package com.mfedorec.astonhomework.homework1.library;

import com.mfedorec.astonhomework.homework1.library.logic.Administrator;
import com.mfedorec.astonhomework.homework1.library.model.Book;
import com.mfedorec.astonhomework.homework1.library.model.Librarian;
import com.mfedorec.astonhomework.homework1.library.model.Reader;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Reader> readers = Arrays.asList(
                new Reader("Федоров И.С."),
                new Reader("Жмышенко А.П."),
                new Reader("Трубецкой Н.А."),
                new Reader("Крапоткина Ю.Т.")
        );

        List<Librarian> librarians = Arrays.asList(
                new Librarian("Библиотекаревич С.В."),
                new Librarian("Строганова Т.Д.")

        );

        List<Book> books = Arrays.asList(
                new Book("Идиот", "Достоевский Ф. М."),
                new Book("Чук и Гек", "Гайдар А. П."),
                new Book("Гарри Поттер", "Роулинг Дж.К.")
        );

        Administrator admin = new Administrator();
        for (Book book : books) {
            admin.addBook(book);
        }

        Random random = new Random();

        for (Reader reader : readers) {
            Book book = books.get(random.nextInt(books.size()));
            if (admin.searchCatalog(book)) {
                Librarian librarian = librarians.get(random.nextInt(librarians.size()));
                if (random.nextBoolean()) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DAY_OF_MONTH, 14);
                    librarian.issueBook(reader, book, calendar.getTime());
                } else {
                    librarian.issueBook(reader, book);
                }
            } else {
                System.out.println("Книга " + book.getTitle() + " автора " + book.getAuthor() + " не найдена в каталоге.");
            }
        }
        for (Reader reader : readers) {
            for (Book book : reader.getBorrowedBooks()) {
                if (book.getIssueType() == Book.IssueType.HOME && book.getIssueDate() != null) {
                    Date currentDate = new Date();
                    if (currentDate.after(book.getIssueDate())) {
                        admin.addToBlacklist(reader);
                        System.out.println("Читатель " + reader.getName() + " занесен в черный список за просрочку книги " + book.getTitle() + ".");
                    }
                }
            }
        }
    }
}