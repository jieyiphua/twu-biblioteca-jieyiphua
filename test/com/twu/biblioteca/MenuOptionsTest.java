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
       assertEquals("Menu" + "\n" + "__________________________" + "\n" + "Press 1 for List of Books" + "\n" + "Press 0 to Quit" + "\n", outContent.toString());
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
      MenuOptions.menuOptionList("1");
      assertEquals("Harry Potter", BookList.bookList.get(0).bookName);
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
