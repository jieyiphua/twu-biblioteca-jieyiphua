package com.twu.biblioteca;

import org.junit.Test;


import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MenuOptionsTest {
   @Test
    public void showMenu() {
       final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
       System.setOut(new PrintStream(outContent));
       MenuOptions.showMenu();
       assertEquals("Menu" + "\n" + "__________________________" + "\n" + "Press 1 for List of Books" + "\n",outContent.toString());
   }

   @Test
   public void errMessage() {
      final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      MenuOptions.errMessage();
      assertEquals("Please select a valid option!\n",outContent.toString());
   }

   @Test
   public void validOptionAccepted() {
      MenuOptions.menuLoop("1");
      assertEquals("Harry Potter", BookList.bookList.get(0).bookName);
   }

   @Test
   public void nonValidOptionRejected() {
      final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      MenuOptions.menuLoop("pop");
      assertEquals("Please select a valid option!\n", outContent.toString());
   }
}