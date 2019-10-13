package com.twu.biblioteca;

import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MovieListTest {

    @After
    public void clearMovieList() {
        MovieList.movieList.clear();
    }

    @Test
    public void canAddMovie() {
        Movie movieGotten = new Movie("name","director",1000,2);
        Movie expectedMovie = MovieList.addMovie(movieGotten).get(0);
        assertEquals(movieGotten,expectedMovie);
    }

    @Test
    public void canGetBookList() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Movie movie1 = new Movie("name1","director1", 1000,1);
        Movie movie2 = new Movie("name2", "director2", 2000,2);
        MovieList.addMovie(movie1);
        MovieList.addMovie(movie2);
        MovieList.getMovieList();
        assertEquals("Movie Name: " + "name1" + "\nDirector: " + "director1" + "\nYear Released: " + 1000 + "\nMovie Rating: " + 1 + "\n\nMovie Name: " + "name2" + "\nDirector: " + "director2" + "\nYear Released: " + 2000 + "\nMovie Rating: " + 2 + "\n\n",outContent.toString());
    }
}
