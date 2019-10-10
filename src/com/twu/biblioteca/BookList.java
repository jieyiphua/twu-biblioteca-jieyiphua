package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {

    private static int bookCount;
    public static ArrayList<Book> bookList = new ArrayList<Book>();

    public static ArrayList<Book> addBook(Book book) {
        bookList.add(book);
        bookCount ++;
        return bookList;
    }

    public static void getBookList() {
        for (int i = 0; i < bookCount; i ++ ) {
            Book bookChosen = bookList.get(i);
            bookChosen.showBook();
        }
    }
}

