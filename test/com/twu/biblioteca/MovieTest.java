package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MovieTest {

    private static ByteArrayOutputStream byteArrayOutputStream;
    private static Movie movieSample;

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        movieSample = new Movie("MovieName","Director",1000,2);
    }

    @Test
    public void testShowMovie() {
        movieSample.showMovie();
        assertEquals(
                "Movie Name: " +
                movieSample.movieName +
                "\nDirector: " +
                movieSample.director +
                "\nYear Released: " +
                movieSample.yearReleased +
                "\nMovie Rating: " +
                movieSample.movieRating +
                "\n\n", byteArrayOutputStream.toString());
    }

}
