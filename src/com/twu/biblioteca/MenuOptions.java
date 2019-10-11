package com.twu.biblioteca;

public class MenuOptions {

    public static void showMenu () {
        System.out.println("Menu");
        System.out.println("__________________________");
        System.out.println("Press 1 for List of Books");
        System.out.println("Press 2 to Checkout Book");
        System.out.println("Press 0 to Quit");
    }

    public static void menuOptionList(String userInput) {
        switch (userInput){
            case "1":
                BookList.getBookList();
                break;

            case "2":
                System.out.println("Which book would you like to check out?");
                CheckOutBooks.showBookListSelection();
                String bookUserInput = BibliotecaApp.getUserInput();
                CheckOutBooks.checkIfInputIsAppropriate(bookUserInput);
                break;

            case "3":
                System.out.println("Which book would you like to return?");


            case "0":
                MenuOptions.exitMessage();
                break;

            default:
                MenuOptions.errMessage();
        }
    }

    public static void menuLoop (String userInput) {
        MenuOptions.menuOptionList(userInput);

        if (!userInput.equals("0")) {
            MenuOptions.showMenu();
            userInput = BibliotecaApp.getUserInput();
            MenuOptions.menuLoop(userInput);
        }
    }

    public static void errMessage() {
        System.out.println("Please select a valid option!");
    }

    public static void exitMessage() {
        System.out.println("Thank you for using Biblioteca!");
    }
}
