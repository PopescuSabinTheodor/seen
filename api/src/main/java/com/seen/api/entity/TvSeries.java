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
public class TvSeries {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private String title;
  
  private String genre;
  
  private String releaseDate;
  
  private Integer noOfSeasons;
  
  private Integer noOfEpisodes;
  
  private String rating;
  
  private String ratingImdb;
  
  private String ratingRottenTomatoes;
  
  private String parentalControl;
  
  private String description;
  
}
