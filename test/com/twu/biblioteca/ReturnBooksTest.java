package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class ReturnBooksTest {

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
    public void testValidCanReturn() {
        bookSample.checkedOut = true;
        ReturnBooks.canReturn(bookSample);
        assertEquals(false, bookSample.checkedOut);
    }

    @Test
    public void testInvalidCanReturn() {
        ReturnBooks.canReturn(bookSample);
        assertEquals("That is not a valid book to return.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void testGetReturnBookList() {
        BookList.addBook(bookSample);
        BookList.addBook(bookSample2);
        ReturnBooks.getReturnBookList();
        assertThat(byteArrayOutputStream.toString(), containsString("Press 1 to return book below"));
        assertThat(byteArrayOutputStream.toString(), containsString("Press 2 to return book below"));
        assertThat(byteArrayOutputStream.toString(), not(containsString("Press 3 to return book below")));
    }

    @Test
    public void testCheckIfNonIntegerInputIsAppropriate() {
        ReturnBooks.checkIfInputIsAppropriate("Hello");
        assertEquals("Sorry, that book is not available\n", byteArrayOutputStream.toString());
    }

    @Test
    public void testCheckIfInvalidInputIsAppropriate() {
        BookList.addBook(bookSample);
        ReturnBooks.checkIfInputIsAppropriate("2");
        assertEquals("Sorry, that book is not available\n", byteArrayOutputStream.toString());
    }

    @Test
    public void testCheckIfValidInputIsAppropriate() {
        BookList.addBook(bookSample);
        bookSample.checkedOut = true;
        ReturnBooks.checkIfInputIsAppropriate("1");
        assertEquals(bookSample.checkedOut, false);
        assertThat(byteArrayOutputStream.toString(), containsString("Thank you for returning the book"));
    }

    @Test
    public void testReturnMessage() {
        ReturnBooks.returnMessage(bookSample);
        assertThat(byteArrayOutputStream.toString(), containsString("Thank you for returning the book"));
        assertThat(byteArrayOutputStream.toString(), containsString(
                "Book Name: " +
                        bookSample.bookName +
                        "\nAuthor: " +
                        bookSample.author +
                        "\nYear Published: " +
                        bookSample.yearPublished
                        + "\n\n"));
    }


}
