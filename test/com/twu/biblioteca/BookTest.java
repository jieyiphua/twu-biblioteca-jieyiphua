package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class BookTest {

    private static ByteArrayOutputStream byteArrayOutputStream;
    private static Book bookSample;

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        bookSample = new Book("BookName","Author",1000);
    }

    @Test
    public void showsBookInformation() {
        bookSample.showBook();
        assertEquals("Book Name: " + bookSample.bookName + "\nAuthor: " + bookSample.author +"\nYear Published: " + bookSample.yearPublished + "\n\n", byteArrayOutputStream.toString());
    }


}
