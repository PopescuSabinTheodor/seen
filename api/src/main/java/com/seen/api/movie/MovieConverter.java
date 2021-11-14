package com.seen.api.movie;

import org.springframework.stereotype.Component;

@Component
public class MovieConverter {

    public Movie toMovie(MovieDto movieDto) {
        return Movie.builder()
                .title(movieDto.getTitle())
                .description(movieDto.getDescription())
                .releaseDate(movieDto.getReleaseDate())
                .build();
    }

}