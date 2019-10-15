package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CheckOutMoviesTest {

    private static ByteArrayOutputStream byteArrayOutputStream;
    private static Movie movieSample;
    private static Movie movieSample2;

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        movieSample = new Movie("MovieName","Director",1000,1);
        movieSample2 = new Movie("MovieName2","Director2",2000,2);
    }

    @After
    public void clearMovieList() {
        MovieList.movieList.clear();
    }

    @Test
    public void testCanCheckOut() {
        CheckOutMovies.canCheckOut(movieSample);
        assertEquals(movieSample.checkedOut,true);
    }

    @Test
    public void testCannotCheckOut() {
        movieSample.checkedOut = true;
        CheckOutMovies.canCheckOut(movieSample);
        assertEquals("Sorry, that movie is not available\n", byteArrayOutputStream.toString());
    }

    @Test
    public void testCheckIfNonIntegerInputIsAppropriate() {
        CheckOutMovies.checkIfInputIsAppropriate("Hello");
        assertEquals("Sorry, that movie is not available\n", byteArrayOutputStream.toString());
    }

    @Test
    public void testCheckIfInvalidInputIsAppropriate() {
        MovieList.addMovie(movieSample);
        CheckOutMovies.checkIfInputIsAppropriate("2");
        assertEquals("Sorry, that movie is not available\n", byteArrayOutputStream.toString());
    }

    @Test
    public void testCheckIfValidInputIsAppropriate() {
        MovieList.addMovie(movieSample);
        CheckOutMovies.checkIfInputIsAppropriate("1");
        assertEquals(movieSample.checkedOut, true);
    }

    @Test
    public void testCurrentCheckOutMovie() {
        CheckOutMovies.currentCheckOutMovie(movieSample);
        assertThat(byteArrayOutputStream.toString(), containsString("Thank you! Enjoy the movie"));
    }

    @Test
    public void testShowMovieListSelection() {
        MovieList.addMovie(movieSample);
        MovieList.addMovie(movieSample2);
        CheckOutMovies.showMovieListSelection();
        assertThat(byteArrayOutputStream.toString(), containsString("Press 1 to checkout movie below"));
        assertThat(byteArrayOutputStream.toString(), containsString("Press 2 to checkout movie below"));
        assertThat(byteArrayOutputStream.toString(), not(containsString("Press 3 to checkout movie below")));
    }
}
