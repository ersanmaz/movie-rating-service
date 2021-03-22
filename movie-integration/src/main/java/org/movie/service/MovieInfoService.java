package org.movie.service;

import org.movie.data.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface MovieInfoService {
    @GetMapping("/movies/{movieId}")
    Movie getMovieById(@PathVariable String movieId);
}
