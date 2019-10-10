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
}
