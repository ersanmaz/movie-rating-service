package org.movie.catalog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.movie.catalog.entity.CatalogItem;
import org.movie.catalog.entity.Movie;
import org.movie.catalog.entity.Rating;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class MovieInfoService {

    public static final String MOVIE_URL = "http://movie-info/movies/";

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject(MOVIE_URL + rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
    }

    public CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("Movie name not found", "", rating.getRating());
    }
}
