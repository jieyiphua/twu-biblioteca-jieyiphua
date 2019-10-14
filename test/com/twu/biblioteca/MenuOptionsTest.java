package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MenuOptionsTest {

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

   @Test
   public void testShowMenu() {
      MenuOptions.showMenu();
      assertThat(byteArrayOutputStream.toString(), containsString("Menu"));
      assertThat(byteArrayOutputStream.toString(), containsString("Press 1 for List of Books"));
      assertThat(byteArrayOutputStream.toString(), containsString("Press 2 to Checkout Book"));
      assertThat(byteArrayOutputStream.toString(), containsString("Press 3 to Return Book"));
      assertThat(byteArrayOutputStream.toString(), containsString("Press 4 for List of Movies"));
      assertThat(byteArrayOutputStream.toString(), containsString("Press 5 to Checkout Movie"));
      assertThat(byteArrayOutputStream.toString(), containsString("Press 0 to Quit"));
   }

   @Test
   public void testErrMessage() {
      MenuOptions.errMessage();
      assertEquals("Please select a valid option!\n", byteArrayOutputStream.toString());
   }

   @Test
   public void testExitMessage() {
      MenuOptions.exitMessage();
      assertEquals("Thank you for using Biblioteca!\n", byteArrayOutputStream.toString());
   }

   @Test
   public void testBookCheckoutMessage() {
      MenuOptions.bookCheckoutMessage();
      assertEquals("Which book would you like to check out?\n", byteArrayOutputStream.toString());
   }

   @Test
   public void testReturnMessage() {
      MenuOptions.bookReturnMessage();
      assertEquals("Which book would you like to return?\n", byteArrayOutputStream.toString());
   }

   @Test
   public void testMovieCheckoutMessage() {
      MenuOptions.movieCheckoutMessage();
      assertEquals("Which movie would you like to check out?\n", byteArrayOutputStream.toString());
   }

   @Test
   public void testValidOptionOne() {
      BookList.addBook(bookSample);
      MenuOptions.menuOptionList("1");
      assertEquals(
              "Book Name: " +
                      bookSample.bookName +
                      "\nAuthor: " +
                      bookSample.author +
                      "\nYear Published: " +
                      bookSample.yearPublished +
                      "\n\n", byteArrayOutputStream.toString());
   }

   @Test
   public void testValidOptionZero() {
      MenuOptions.menuOptionList("0");
      assertEquals("Thank you for using Biblioteca!\n", byteArrayOutputStream.toString());
   }

   @Test
   public void testNonValidOption() {
      MenuOptions.menuOptionList("pop");
      assertEquals("Please select a valid option!\n", byteArrayOutputStream.toString());
   }

   /*
   Test for option 3, 2 & Menu Loop. However, they have input required.
    */
}
