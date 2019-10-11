package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ReturnBooksTest {

    @Test
    public void canReturn() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book bookCanReturn = new Book("Return","Return",1000);
        bookCanReturn.checkedOut = true;
        ReturnBooks.canReturn(bookCanReturn);
        assertEquals(false, bookCanReturn.checkedOut);
    }

    @Test
    public void cannotReturn() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book bookCanReturn = new Book("Return","Return",1000);
        ReturnBooks.canReturn(bookCanReturn);
        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }

    @Test
    public void returnMessage() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book bookCanReturn = new Book("Return","Return",1000);
        ReturnBooks.returnMessage(bookCanReturn);
        assertEquals("Thank you for returning the book\n" + "Book Name: " + "Return" + "\nAuthor: " + "Return" +"\nYear Published: " + 1000 + "\n\n", outContent.toString());
    }


}
