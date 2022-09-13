package com.seen.api.tvseries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class TvSeriesEpisode {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long TvSeriesId;

  private Integer season;
  
  private Integer episode;
  
  private String title;
  
  private String duration;
  
  private String description;
  
  private String rating;
  
  private String ratingImdb;
  
  private String ratingRottenTomatoes;

}
