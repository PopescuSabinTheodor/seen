package com.seen.api.movie;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
  
  private final MovieService movieService;
  private final MovieConverter movieConverter;

  public MovieController(MovieService movieService,  MovieConverter movieConverter) {
    this.movieService = movieService;
    this.movieConverter = movieConverter;
  }

  /**
   * Search movie by title.
   * 
   * @param title The movie title.
   * 
   * @return 
   */
  @GetMapping("/api/movie/search")
  public Page<Movie> search(@RequestParam(value = "title", required = true) String title,
      @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        Pageable pageable = PageRequest.of(page, size);
    return movieService.searchMovieByTitle(title, pageable);
  }

  /**
   *Add a movie to database.
   *
   * @param movieDTO Movie payload.
   *
   * @return An object of type Movie.
   */
  @ApiOperation(value = "Add movie to database", response = MovieDto.class)
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "New movie added to database"),
          @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
          @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource", content = @Content),
          @ApiResponse(responseCode = "403", description = "Access forbidden", content = @Content),
          @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
          @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
  })
  @PostMapping(value = "/api/movie/save")
  public Movie addMovie(@RequestBody MovieDto movieDTO) {
    Movie movie = movieConverter.toMovie(movieDTO);
    return movieService.saveMovie(movie);
  }

  /**
   * Delete a movie from database.
   *
   * @param movieId ID of the record to delete.
   */
  @ApiOperation(value = "Delete movie from database", response = ResponseEntity.class)
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Record deleted"),
          @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
          @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource", content = @Content),
          @ApiResponse(responseCode = "403", description = "Access forbidden", content = @Content),
          @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
          @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
  })
  @DeleteMapping(value = "/api/movie/delete")
  public void deleteOrder(@RequestParam(value = "id") Long movieId) {
    movieService.deleteMovie(movieId);
  }

  /**
   * Update an existing movie in the database.
   *
   * @param movieId ID of the record to update.
   *
   * @param movieDto Movie payload.
   *
   * @return An object of type Movie
   */
  @ApiOperation(value = "Edit a movie", response = ResponseEntity.class)
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Record updated"),
          @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
          @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource", content = @Content),
          @ApiResponse(responseCode = "403", description = "Access forbidden", content = @Content),
          @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
          @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
  })
  @PutMapping(value = "/api/movie/edit", produces = MediaType.APPLICATION_JSON_VALUE)
  public Movie editMovie(@RequestParam(value= "id") Long movieId, @RequestBody MovieDto movieDto) {
    Movie movie = movieConverter.toMovie(movieDto);
    if (movieService.findMovieById(movieId).isPresent()) {
      Movie existingMovie = movieService.findMovieById(movieId).get();

      existingMovie.setTitle(movieDto.getTitle());
      existingMovie.setDescription(movieDto.getDescription());
      existingMovie.setDuration(movieDto.getDuration());
      existingMovie.setReleaseDate(movieDto.getReleaseDate());
      existingMovie.setGenre(movieDto.getGenre());
      existingMovie.setRating(movieDto.getRating());
      existingMovie.setRatingImdb(movieDto.getRatingImdb());
      existingMovie.setRatingRottenTomatoes(movieDto.getRatingRottenTomatoes());
      existingMovie.setParentalControl(movieDto.getParentalControl());

      movieService.saveMovie(existingMovie);
    }
    return movie;
  }

}
