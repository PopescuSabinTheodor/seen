package com.seen.api.movie;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seen.api.user.User;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movie")
  private User user;

}
