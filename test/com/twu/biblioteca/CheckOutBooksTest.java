package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.CoreMatchers.containsString;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CheckOutBooksTest {

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
    public void testCanCheckOut() {
        CheckOutBooks.canCheckOut(bookSample);
        assertEquals(bookSample.checkedOut,true);
    }

    @Test
    public void testCannotCheckOut() {
        bookSample2.checkedOut = true;
        CheckOutBooks.canCheckOut(bookSample2);
        assertEquals("Sorry, that book is not available\n", byteArrayOutputStream.toString());
    }

    @Test
    public void testCheckIfNonIntegerInputIsAppropriate() {
        CheckOutBooks.checkIfInputIsAppropriate("Hello");
        assertEquals("Sorry, that book is not available\n", byteArrayOutputStream.toString());
    }

    @Test
    public void testCheckIfInvalidInputIsAppropriate() {
        BookList.addBook(bookSample);
        CheckOutBooks.checkIfInputIsAppropriate("2");
        assertEquals("Sorry, that book is not available\n", byteArrayOutputStream.toString());
    }

    @Test
    public void testCheckIfValidInputIsAppropriate() {
        BookList.addBook(bookSample);
        CheckOutBooks.checkIfInputIsAppropriate("1");
        assertEquals(bookSample.checkedOut, true);
    }

    @Test
    public void testCurrentCheckOutBook() {
        CheckOutBooks.currentCheckOutBook(bookSample);
        assertThat(byteArrayOutputStream.toString(), containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void testShowBookListSelection() {
        BookList.addBook(bookSample);
        BookList.addBook(bookSample2);
        CheckOutBooks.showBookListSelection();
        assertThat(byteArrayOutputStream.toString(), containsString("Press 1 to checkout book below"));
        assertThat(byteArrayOutputStream.toString(), containsString("Press 2 to checkout book below"));
        assertThat(byteArrayOutputStream.toString(), not(containsString("Press 3 to checkout book below")));
    }
}
