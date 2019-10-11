package com.twu.biblioteca;

public class ReturnBooks {

    public static void canReturn(Book book) {
        if (book.checkedOut) {
            book.checkedOut = false;
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }


}
