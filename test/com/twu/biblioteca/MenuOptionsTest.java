package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class MenuOptionsTest {
   @Test
    public void showMenu() {
       final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
       System.setOut(new PrintStream(outContent));
       MenuOptions.showMenu();
       assertEquals("Menu" + "\n" + "__________________________" + "\n" + "Press 1 for List of Books" + "\n" + "Press 2 to Checkout Book" + "\n" + "Press 3 to Return Book"  + "\n" + "Press 4 for List of Movies"  + "\n" + "Press 0 to Quit" + "\n", outContent.toString());
   }

   @Test
   public void errMessage() {
      final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      MenuOptions.errMessage();
      assertEquals("Please select a valid option!\n", outContent.toString());
   }

   @Test
   public void exitMessage() {
      final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      MenuOptions.exitMessage();
      assertEquals("Thank you for using Biblioteca!\n", outContent.toString());
   }

   @Test
   public void validOptionOne() {
      final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      BookList.addBook(new Book("Harry Potter", "JK Rowling", 1000));
      MenuOptions.menuOptionList("1");
      assertEquals("Book Name: " + "Harry Potter" + "\nAuthor: " + "JK Rowling" +"\nYear Published: " + 1000 + "\n\n",outContent.toString());
   }

   @Test
   public void validOptionZero() {
      final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      MenuOptions.menuOptionList("0");
      assertEquals("Thank you for using Biblioteca!\n", outContent.toString());
   }

   @Test
   public void nonValidOptionRejected() {
      final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      MenuOptions.menuOptionList("pop");
      assertEquals("Please select a valid option!\n", outContent.toString());
   }
}
