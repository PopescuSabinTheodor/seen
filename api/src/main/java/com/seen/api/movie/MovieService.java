package com.seen.api.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
  
  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public Page<Movie> searchMovieByTitle(String title, Pageable pageable) {
    return movieRepository.findAllByTitle(title, pageable);
  }
}
