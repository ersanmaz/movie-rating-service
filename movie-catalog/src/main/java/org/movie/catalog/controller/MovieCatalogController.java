package org.movie.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.movie.catalog.entity.CatalogItem;
import org.movie.catalog.entity.Movie;
import org.movie.catalog.entity.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
@RequiredArgsConstructor
public class MovieCatalogController {

    public static final String MOVIE_URL = "http://movie-info/movies/";
    public static final String RATING_URL = "http://rating-data/ratings/users/";

    private final RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogByUserId(@PathVariable String userId) {

        UserRating userRating = restTemplate.getForObject(RATING_URL + userId, UserRating.class);
        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject(MOVIE_URL + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
