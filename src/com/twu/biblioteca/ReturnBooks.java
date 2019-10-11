package com.twu.biblioteca;

public class ReturnBooks {

    public static void canReturn(Book book) {
        if (book.checkedOut) {
            ReturnBooks.returnMessage(book);
            book.checkedOut = false;
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public static void getReturnBookList() {
        int count = 0;
        for (int i = 0; i < BookList.bookList.size(); i ++ ) {
                int numberShown = count + 1;
                System.out.println("Press " + numberShown + " to return book below");
                Book bookChosen = BookList.bookList.get(i);
                bookChosen.showBook();
                count ++;
        }
    }

    public static void checkIfInputIsAppropriate (String userInput) {
        if( BibliotecaApp.isInteger(userInput)) {
            int indexOfBook = Integer.parseInt(userInput) - 1;
            if (indexOfBook < BookList.bookList.size() && indexOfBook >= 0) {
                Book bookToCheckOut = BookList.bookList.get(indexOfBook);
                ReturnBooks.canReturn(bookToCheckOut);
            } else {
                System.out.println("Sorry, that book is not available");
            }
        } else {
            System.out.println("Sorry, that book is not available");
        }
    }

    public static void returnMessage(Book book) {
        System.out.println("Thank you for returning the book");
        book.showBook();
    }

}
