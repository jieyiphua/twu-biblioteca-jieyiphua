package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {

    public static ArrayList<Book> bookList = new ArrayList<Book>();

    public static ArrayList<Book> addBook(Book book) {
        bookList.add(book);
        return bookList;
    }

    public static void originalBookList() {
        Book book1 = new Book("Harry Potter", "JK Rowling", 1000);
        Book book2 = new Book("Lord Of The Ring", "J.R.R Tolkien", 2000);
        BookList.addBook(book1);
        BookList.addBook(book2);
    }

    public static void getBookList() {
        for (int i = 0; i < bookList.size(); i ++ ) {
            if (!bookList.get(i).checkedOut) {
            Book bookChosen = bookList.get(i);
            bookChosen.showBook();
            }
        }
    }
}

