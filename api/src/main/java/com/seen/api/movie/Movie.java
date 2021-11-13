package com.seen.api.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Movie {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private String title;
  
  private String description;
  
  private String duration;
  
  private String releaseDate;
  
  private String genre;
  
  private String rating;
  
  private String ratingImdb;
  
  private String ratingRottenTomatoes;
  
  private String parentalControl;

  @Component
  @Scope("prototype")
  static class MovieBuilder {
    private MovieBuilder() {}

    private Long id;
  
    private String title;
    
    private String description;
    
    private String duration;
    
    private String releaseDate;
    
    private String genre;
    
    private String rating;
    
    private String ratingImdb;
    
    private String ratingRottenTomatoes;
    
    private String parentalControl;
    
    public MovieBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public MovieBuilder title(String title) {
      this.title = title;
      return this;
    }

    public MovieBuilder description(String description) {
      this.description = description;
      return this;
    }

    public MovieBuilder duration(String duration) {
      this.duration = duration;
      return this;
    }

    public MovieBuilder releaseDate(String releaseDate) {
      this.releaseDate = releaseDate;
      return this;
    }

    public MovieBuilder genre(String genre) {
      this.genre = genre;
      return this;
    }

    public MovieBuilder rating(String rating) {
      this.rating = rating;
      return this;
    }

    public MovieBuilder ratingImdb(String ratingImdb) {
      this.ratingImdb = ratingImdb;
      return this;
    }

    public MovieBuilder ratingRottenTomatoes(String ratingRottenTomatoes) {
      this.ratingRottenTomatoes = ratingRottenTomatoes;
      return this;
    }

    public MovieBuilder parentalControl(String parentalControl) {
      this.parentalControl = parentalControl;
      return this;
    }

    public Movie build() {
      return new Movie(id, title, description, duration, releaseDate, genre, rating, ratingImdb, ratingRottenTomatoes, parentalControl);
    }

  }

}
