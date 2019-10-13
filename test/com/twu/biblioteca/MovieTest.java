package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void showsMovieInformation() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Movie movie1 = new Movie("name","director",1000,2);
        movie1.showMovie();
        assertEquals("Movie Name: " + "name" + "\nDirector: " + "director" + "\nYear Released: " + 1000 + "\n Movie Rating: " + 2 + "\n\n",outContent.toString());
    }

}
