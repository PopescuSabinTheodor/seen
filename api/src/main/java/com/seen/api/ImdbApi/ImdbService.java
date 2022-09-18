package com.seen.api.ImdbApi;

import com.seen.api.errorHandling.RestExceptionHandler;
import com.seen.api.movie.Movie;
import com.seen.api.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ImdbService {

    ImdbConstants constants;

    @Autowired
    RestTemplate template;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    RestExceptionHandler restExceptionHandler;

    public ResponseEntity<String> findMovieByTitle(String movieTitle) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(constants.headerName, constants.APIKey);

        HttpEntity<Object> entity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response =
                template.exchange(
                        constants.findMovieByTitleURL + movieTitle,
                        HttpMethod.GET,
                        entity,
                        String.class
                );

        return response;
    }

    public ResponseEntity<Object> userSearchMovieByTitle(String movieTitle) {
        Optional<Movie> movie = movieRepository.findByTitle(movieTitle);
        if (movie.isPresent()) {
            Movie searchedMovie = movie.get();

            return ResponseEntity.ok()
                    .body(searchedMovie.toString());
        } else {
            //findMovieByTitle(movieTitle);
            String movieNotFound = "Movie was not found for parameters {title=" + movieTitle + "}";
            return restExceptionHandler.handleEntityNotFound(movieNotFound);
        }
    }
}
