package com.seen.api.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/api/movie/save")
  public Movie addMovie(@RequestBody MovieDto movieDTO) {
    Movie movie = movieConverter.toMovie(movieDTO);
    return movieService.saveMovie(movie);
  }

  @DeleteMapping("/api/movie/delete")
  public void deleteOrder(@RequestParam(value = "id") Long movieId) {
    movieService.deleteMovie(movieId);
  }
}
