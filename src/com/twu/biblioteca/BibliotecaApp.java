package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        welcomeMessage();
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
}

