package com.twu.biblioteca;

public class Book {
    public String bookName;
    public String author;
    public int yearPublished;
    public boolean checkedOut;


    public Book(String bookName, String author, int yearPublished) {
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = false;
    }

    public void showBook() {
        System.out.println(
                "Book Name: " +
                this.bookName +
                "\nAuthor: " +
                this.author +
                "\nYear Published: " +
                this.yearPublished + "\n");
    }

}
