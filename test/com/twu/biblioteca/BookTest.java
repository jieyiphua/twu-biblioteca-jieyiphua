package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void showsBookInformation() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book book1 = new Book("BookName","Author",1000);
        book1.showBook();
        assertEquals("Book Name: " + book1.bookName + "\nAuthor: " + book1.author +"\nYear Published: " + book1.yearPublished + "\n",outContent.toString());
    }


}
