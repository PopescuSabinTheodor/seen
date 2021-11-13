package com.seen.api.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter {

    @Autowired
    private Movie.MovieBuilder movieBuilder;

    public Movie toMovie(MovieDto movieDto) {
        Movie movie = movieBuilder
                .title(movieDto.getTitle())
                .description(movieDto.getDescription())
                .releaseDate(movieDto.getReleaseDate())
                .build();
        return movie;

    }

}