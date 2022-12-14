package com.seen.api.ImdbApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImdbController {

    @Autowired
    private ImdbService imdbService;

    @GetMapping("api/movie/v2/find")
    public ResponseEntity<String> getMoviesByTitle(@RequestParam(name = "title") String title) {
        return imdbService.findMovieByTitle(title);
    }
}
