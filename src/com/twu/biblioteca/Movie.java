package com.twu.biblioteca;

public class Movie {

    public String movieName;
    public String director;
    public int yearReleased;
    public int movieRating;

    public Movie(String movieName, String director, int yearReleased, int movieRating) {
        this.movieName = movieName;
        this.director = director;
        this.yearReleased = yearReleased;
        this.movieRating = movieRating;
    }

    public void showMovie() {
        System.out.println(
                "Movie Name: " +
                this.movieName +
                "\nDirector: " +
                this.director +
                "\nYear Released: " +
                this.yearReleased +
                "\n Movie Rating: " +
                this.movieRating + "\n");
    }
}
