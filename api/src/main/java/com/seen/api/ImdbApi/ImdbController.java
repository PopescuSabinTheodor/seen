package com.seen.api.ImdbApi;

import com.seen.api.movie.Movie;
import com.seen.api.movie.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
public class ImdbController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    private ImdbService imdbService;

    @GetMapping("api/movie/v2/find")
    public ResponseEntity<String> getMoviesByTitle(@RequestParam(name = "title") String title) {
        return imdbService.findMovieByTitle(title);
    }

    @GetMapping("api/movie/{title}/searchedMovie")
    public Optional<Movie> searchMovieByTitle(@PathVariable(value = "title") String title) {

        Optional<Movie> movie = movieRepository.findByTitle(title);

        if (!movie.isPresent()) {
           throw new EntityNotFoundException();
        }

        return imdbService.userSearchMovieByTitle(title);
    }
}
