package org.movie.info.controller;

import org.movie.data.Movie;
import org.movie.data.MovieSummary;
import org.movie.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MovieInfoController implements MovieInfoService {

    private static final String MOVIE_DB_URL = "https://api.themoviedb.org/3/movie/";

    @Value("${api.key}")
    private String apiKey;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public Movie getMovieById(@PathVariable String movieId) {
        MovieSummary movieSummary = restTemplate.getForObject(MOVIE_DB_URL + movieId + "?api_key=" +  apiKey, MovieSummary.class);
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());

    }
}
