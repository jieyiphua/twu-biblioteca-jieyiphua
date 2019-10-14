package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookListTest {

    private static ByteArrayOutputStream byteArrayOutputStream;
    private static Book bookSample;
    private static Book bookSample2;

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        bookSample = new Book("BookName","Author",1000);
        bookSample2 = new Book("BookName2","Author2",2000);
    }

    @After
    public void clearBookList() {
        BookList.bookList.clear();
    }

    @Test
    public void testAddBook() {
        Book bookGotten = BookList.addBook(bookSample).get(0);
        assertEquals(bookSample,bookGotten);
    }

    @Test
    public void testGetBookList() {
        BookList.addBook(bookSample);
        BookList.addBook(bookSample2);
        BookList.getBookList();
        assertEquals(
            "Book Name: " +
            bookSample.bookName +
            "\nAuthor: " +
            bookSample.author +
            "\nYear Published: " +
            bookSample.yearPublished + "\n\n" +
            "Book Name: " +
            bookSample2.bookName +
            "\nAuthor: " +
            bookSample2.author +
            "\nYear Published: " +
            bookSample2.yearPublished + "\n\n", byteArrayOutputStream.toString());
    }
}
