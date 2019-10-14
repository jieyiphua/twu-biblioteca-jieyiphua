package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieList {

    public static ArrayList<Movie> movieList = new ArrayList<Movie>();


    public static void originalMovieList() {
        Movie movie1 = new Movie("Avengers","Director", 2012,7);
        Movie movie2 = new Movie("Harry Potter", "JK Rowling", 1000,8);
        MovieList.addMovie(movie1);
        MovieList.addMovie(movie2);
    }

    public static ArrayList<Movie> addMovie(Movie movie) {
        movieList.add(movie);
        return movieList;
    }

    public static void getMovieList() {
        for (int i = 0; i < movieList.size(); i ++ ) {
            Movie chosen = movieList.get(i);
            chosen.showMovie();
        }
    }
}
