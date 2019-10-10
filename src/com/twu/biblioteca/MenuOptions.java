package com.twu.biblioteca;

public class MenuOptions {
    public static void showMenu () {
        System.out.println("Menu");
        System.out.println("__________________________");
        System.out.println("Press 1 for List of Books");
    }

    public static void menuLoop (String userInput) {

        if (userInput.equals("1")) {
            Book book1 = new Book("Harry Potter", "JK Rowling", 1000);
            Book book2 = new Book("Lord Of The Ring", "J.R.R Tolkien", 2000);
            BookList.addBook(book1);
            BookList.addBook(book2);
            BookList.getBookList();
        }

    }

}
