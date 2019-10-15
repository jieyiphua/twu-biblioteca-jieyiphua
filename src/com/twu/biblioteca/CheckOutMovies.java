package com.twu.biblioteca;

public class CheckOutMovies {

    public static void canCheckOut(Movie movie) {
        if (movie.checkedOut) {
            System.out.println("Sorry, that movie is not available");
        } else {
            CheckOutMovies.currentCheckOutMovie(movie);
            movie.checkedOut = true;
        }
    }

    public static void checkIfInputIsAppropriate (String userInput) {
        if( BibliotecaApp.isInteger(userInput)) {
            int indexOfMovie = Integer.parseInt(userInput) - 1;
            if (indexOfMovie < MovieList.movieList.size() && indexOfMovie >= 0) {
                Movie movieToCheckOut = MovieList.movieList.get(indexOfMovie);
                CheckOutMovies.canCheckOut(movieToCheckOut);
            } else {
                System.out.println("Sorry, that movie is not available");
            }
        } else {
            System.out.println("Sorry, that movie is not available");
        }
    }

    public static void currentCheckOutMovie(Movie movie) {
        System.out.println("Thank you! Enjoy the movie");
        movie.showMovie();
    }

    public static void showMovieListSelection() {
        for (int i = 0; i < MovieList.movieList.size(); i ++ ) {
            Movie movieChosen = MovieList.movieList.get(i);
            int numberShown = i + 1;
            System.out.println("Press " + numberShown + " to checkout movie below");
            movieChosen.showMovie();
        }
    }
}
