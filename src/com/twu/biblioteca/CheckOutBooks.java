package com.twu.biblioteca;

import com.sun.tools.javac.comp.Check;

public class CheckOutBooks {

    public static int numberOfBooks;

    public static void canCheckOut(Book book) {
        if (book.checkedOut) {
            System.out.println("Sorry, that book is not available");
        } else {
            CheckOutBooks.currentCheckOutBook(book);
            book.checkedOut = true;
        }
    }

    public static void checkIfInputIsAppropriate (String userInput) {

        if( BibliotecaApp.isInteger(userInput)) {
            int indexOfBook = Integer.parseInt(userInput);
            if (indexOfBook < BookList.bookList.size() && indexOfBook >= 0) {
                Book bookToCheckOut = BookList.bookList.get(indexOfBook - 1);
                CheckOutBooks.canCheckOut(bookToCheckOut);
            } else {
                System.out.println("Sorry, that book is not available");
            }
        } else {
            System.out.println("Sorry, that book is not available");
        }
    }

    public static void currentCheckOutBook(Book book) {
        System.out.println("Thank you! Enjoy the book");
        book.showBook();
    }

    public static void showBookListSelection() {
        for (int i = 0; i < BookList.bookList.size(); i ++ ) {
            Book bookChosen = BookList.bookList.get(i);
            int numberShown = i + 1;
            System.out.println("Press " + numberShown + " to checkout book below");
            bookChosen.showBook();
            numberOfBooks++;
        }
    }
}
