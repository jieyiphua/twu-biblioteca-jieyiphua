package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        welcomeMessage();
        BookList.originalBookList();
        MovieList.originalMovieList();
        UserList.originalUserList();
        MenuOptions.showMenu();
        String userInput = getUserInput();
        MenuOptions.menuLoop(userInput);
    }

    static String getUserInput() {
        Scanner in = new Scanner(System.in);
        String input;
        input = in.nextLine();
        return input;
    }

    static void welcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}

