package com.seen.api.movie;

import io.swagger.v3.oas.annotations.media.Schema;

public class MovieDto {

    @Schema(example= "Game of Thrones", description = "Movie title")
    private String title;

    @Schema(example= "As good as a dog poop", description = "Movie description")
    private String description;

    @Schema(example= "3h", description = "Movie duration")
    private String duration;

    @Schema(example= "19.05.2018", description = "Movie release date")
    private String releaseDate;

    @Schema(example= "SF", description = "Movie genre")
    private String genre;

    @Schema(example= "8.4", description = "Movie rating")
    private String rating;

    @Schema(example= "9.5", description = "Movie Imdb rating")
    private String ratingImdb;

    @Schema(example= "9.0", description = "Movie Rotten Tomatoes rating")
    private String ratingRottenTomatoes;

    @Schema(example= "15+", description = "Movie parental control")
    private String parentalControl;

    public MovieDto(String title, String description, String duration, String releaseDate, String genre, String rating, String ratingImdb, String ratingRottenTomatoes, String parentalControl) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rating = rating;
        this.ratingImdb = ratingImdb;
        this.ratingRottenTomatoes = ratingRottenTomatoes;
        this.parentalControl = parentalControl;
    }

    public MovieDto() {}  

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }   

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRatingImdb() {
        return ratingImdb;
    }

    public void setRatingImdb(String ratingImdb) {
        this.ratingImdb = ratingImdb;
    }

    public String getRatingRottenTomatoes() {
        return ratingRottenTomatoes;
    }

    public void setRatingRottenTomatoes(String ratingRottenTomatoes) {
        this.ratingRottenTomatoes = ratingRottenTomatoes;
    }

    public String getParentalControl() {
        return parentalControl;
    }

    public void setParentalControl(String parentalControl) {
        this.parentalControl = parentalControl;
    }

    @Override
    public String toString() {
        return "MovieDto [title=" + title + ", description=" + description + ", duration=" + duration + ", releaseDate=" + releaseDate + ", genre=" + genre + ", rating=" + rating + ", ratingImdb=" + ratingImdb + ", ratingRottenTomatoes=" + ratingRottenTomatoes + ", parentalControl=" + parentalControl + "]";
    }


}

