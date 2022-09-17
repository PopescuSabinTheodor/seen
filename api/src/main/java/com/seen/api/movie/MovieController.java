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

@RestController
public class MovieController {
  
  private final MovieService movieService;
  private final MovieConverter movieConverter;

  public MovieController(MovieService movieService,  MovieConverter movieConverter) {
    this.movieService = movieService;
    this.movieConverter = movieConverter;
  }

  @GetMapping("/api/movie/search")
  public Page<Movie> search(@RequestParam(value = "title", required = true) String title,
      @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        Pageable pageable = PageRequest.of(page, size);
    return movieService.searchMovieByTitle(title, pageable);
  }

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

  @ApiOperation(value = "Delete movie from database", response = ResponseEntity.class)
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Record deleted"),
          @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
          @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource", content = @Content),
          @ApiResponse(responseCode = "403", description = "Access forbidden", content = @Content),
          @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
          @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
  })
  @DeleteMapping(value = "/api/movie/{id}/delete")
  public void deleteOrder(@PathVariable(value = "id") Long movieId) {
    movieService.deleteMovie(movieId);
  }

  @ApiOperation(value = "Edit a movie", response = ResponseEntity.class)
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Record updated"),
          @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
          @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource", content = @Content),
          @ApiResponse(responseCode = "403", description = "Access forbidden", content = @Content),
          @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
          @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
  })
  @PutMapping(value = "/api/movie/{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE)
  public void editMovie(@PathVariable(value = "id") Long movieId, @RequestBody MovieDto movieDto) {
      movieService.updateMovie(movieDto, movieId);
  }
}
