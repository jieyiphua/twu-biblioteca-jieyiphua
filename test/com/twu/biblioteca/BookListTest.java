package com.twu.biblioteca;

import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookListTest {
    @After
    public void clearBookList() {
        BookList.bookList.clear();
    }

    @Test
    public void canAddBook() {
        Book expectedBook = new Book("BookName","Author",1000);
        Book bookGotten = BookList.addBook(expectedBook).get(0);
        assertEquals(bookGotten,expectedBook);
    }

    @Test
    public void canGetBookList() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book book1 = new Book("BookName1","Author1",1000);
        Book book2 = new Book("BookName2","Author2",2000);
        BookList.addBook(book1);
        BookList.addBook(book2);
        BookList.getBookList();
        assertEquals("Book Name: " + book1.bookName + "\nAuthor: " + book1.author +"\nYear Published: " + book1.yearPublished + "\n\n" + "Book Name: " + book2.bookName + "\nAuthor: " + book2.author +"\nYear Published: " + book2.yearPublished + "\n\n",outContent.toString());
    }
}
