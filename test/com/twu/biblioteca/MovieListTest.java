package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MovieListTest {

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
    public void canAddMovie() {
        Movie expectedMovie = MovieList.addMovie(movieSample).get(0);
        assertEquals(movieSample, expectedMovie);
    }

    @Test
    public void canGetBookList() {
        MovieList.addMovie(movieSample);
        MovieList.addMovie(movieSample2);
        MovieList.getMovieList();
        assertEquals(
                "Movie Name: " +
                movieSample.movieName +
                "\nDirector: " +
                movieSample.director +
                "\nYear Released: " +
                movieSample.yearReleased +
                "\nMovie Rating: " +
                movieSample.movieRating +
                "\n\nMovie Name: " +
                movieSample2.movieName +
                "\nDirector: " +
                movieSample2.director +
                "\nYear Released: " +
                movieSample2.yearReleased +
                "\nMovie Rating: " +
                movieSample2.movieRating +
                "\n\n", byteArrayOutputStream.toString());
    }
}
