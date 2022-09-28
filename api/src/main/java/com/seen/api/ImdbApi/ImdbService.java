package com.seen.api.ImdbApi;

import com.seen.api.error.exception.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ImdbService {

    private static final String APIKey = "5f530ddaa2msh3a4c126c7b75b34p1ac5d5jsn51d7b3983b66";
    private static final String findMovieByTitleURL = "https://imdb8.p.rapidapi.com/title/v2/find?title=";
    private static final String headerName = "X-RapidAPI-Key";

    @Autowired
    RestTemplate template;

    public ResponseEntity<String> findMovieByTitle(String movieTitle) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(headerName, APIKey);

        HttpEntity<Object> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                template.exchange(
                        findMovieByTitleURL + movieTitle,
                        HttpMethod.GET,
                        entity,
                        String.class
                );

        return response;
    }
}
