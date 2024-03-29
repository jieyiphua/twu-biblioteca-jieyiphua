package com.twu.biblioteca;

public class MenuOptions {

    public static void showMenu () {
        System.out.println("Menu");
        System.out.println("__________________________");
        System.out.println("Press 1 for List of Books");
        System.out.println("Press 2 to Checkout Book");
        System.out.println("Press 3 to Return Book");
        System.out.println("Press 4 for List of Movies");
        System.out.println("Press 5 to Checkout Movie");
        System.out.println("Press 0 to Quit");
    }

    public static void menuOptionList(String userInput) {
        switch (userInput){
            case "1":
                BookList.getBookList();
                break;

            case "2":
                MenuOptions.bookCheckoutMessage();
                CheckOutBooks.showBookListSelection();
                String checkOutBookUserInput = BibliotecaApp.getUserInput();
                CheckOutBooks.checkIfInputIsAppropriate(checkOutBookUserInput);
                break;

            case "3":
                MenuOptions.bookReturnMessage();
                ReturnBooks.getReturnBookList();
                String returnBookUserInput = BibliotecaApp.getUserInput();
                ReturnBooks.checkIfInputIsAppropriate(returnBookUserInput);
                break;

            case "4":
                MovieList.getMovieList();
                break;

            case "5":
                MenuOptions.bookCheckoutMessage();
                CheckOutMovies.showMovieListSelection();
                String checkOutMovieUserInput = BibliotecaApp.getUserInput();
                CheckOutMovies.checkIfInputIsAppropriate(checkOutMovieUserInput);
                break;

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

    public static void bookCheckoutMessage() {
        System.out.println("Which book would you like to check out?");
    }

    public static void movieCheckoutMessage() {
        System.out.println("Which movie would you like to check out?");
    }

    public static void bookReturnMessage() {
        System.out.println("Which book would you like to return?");
    }
}
