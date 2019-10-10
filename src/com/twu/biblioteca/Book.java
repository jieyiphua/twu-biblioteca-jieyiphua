package com.twu.biblioteca;

public class Book {
    public String bookName;
    public String author;
    public int yearPublished;


    public Book(String bookName, String author, int yearPublished) {
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void showBook() {
        System.out.println(
                "Book Name: " +
                this.bookName +
                "\nAuthor: " +
                this.author +
                "\nYear Published: " +
                this.yearPublished );
    }

}
