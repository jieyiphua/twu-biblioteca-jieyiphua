package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CheckOutBooksTest {
    @Test
    public void canCheckOut() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book bookInLibrary = new Book("Library","Author",2000);
        CheckOutBooks.canCheckOut(bookInLibrary);
        assertEquals(bookInLibrary.checkedOut,true);
    }

    @Test
    public void cannotCheckOut() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book checkedOutBook = new Book("Harry Potter", "JK Rowling", 1000);
        checkedOutBook.checkedOut = true;
        CheckOutBooks.canCheckOut(checkedOutBook);
        assertEquals("Sorry, that book is not available\n",outContent.toString());
    }

    @Test
    public void currentCheckOutBook() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book checkedOutBook = new Book("Harry Potter", "JK Rowling", 1000);
        CheckOutBooks.currentCheckOutBook(checkedOutBook);
        assertEquals("Thank you! Enjoy the book\n" + "Book Name: " + "Harry Potter" + "\nAuthor: " + "JK Rowling" +"\nYear Published: " + 1000 + "\n\n", outContent.toString());
    }
}
