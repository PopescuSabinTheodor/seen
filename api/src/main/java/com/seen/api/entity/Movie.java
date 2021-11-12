package com.seen.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
