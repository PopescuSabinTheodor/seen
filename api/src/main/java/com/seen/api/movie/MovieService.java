package com.seen.api.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
  
  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public Page<Movie> searchMovieByTitle(String title, Pageable pageable) {
    return movieRepository.findAllByTitle(title, pageable);
  }

  public Optional<Movie> findMovieById(Long movieId) {
    return movieRepository.findById(movieId);
  }

  public Movie saveMovie(Movie movie) {
    return movieRepository.save(movie);
  }

  public void deleteMovie(Long id) {
    movieRepository.deleteById(id);
  }

  public void updateMovie(MovieDto movieDto, Long movieId) {
    Optional<Movie> movieOptional = movieRepository.findById(movieId);
    if (movieOptional.isPresent()) {
      Movie updatedMovie = movieOptional.get();

      updatedMovie.setTitle(movieDto.getTitle());
      updatedMovie.setDescription(movieDto.getDescription());
      updatedMovie.setDuration(movieDto.getDuration());
      updatedMovie.setReleaseDate(movieDto.getReleaseDate());
      updatedMovie.setGenre(movieDto.getGenre());
      updatedMovie.setRating(movieDto.getRating());
      updatedMovie.setRatingImdb(movieDto.getRatingImdb());
      updatedMovie.setRatingRottenTomatoes(movieDto.getRatingRottenTomatoes());
      updatedMovie.setParentalControl(movieDto.getParentalControl());

      movieRepository.save(updatedMovie);
    }
  }
}
