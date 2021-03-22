package org.movie.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.movie.catalog.service.RatingDataProvider;
import org.movie.data.CatalogItem;
import org.movie.data.Rating;
import org.movie.service.MovieInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
@RequiredArgsConstructor
public class MovieCatalogController {

    private final RatingDataProvider ratingDataProvider;
    private final MovieInfoService movieInfoService;

    @GetMapping("/ratings/{movieId}")
    public Rating getMovieRating(@PathVariable String movieId) {
        return ratingDataProvider.getRatingByMovieId(movieId);
    }

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogByUserId(@PathVariable String userId) {
        return ratingDataProvider.getRatingsByUserId(userId)
                .getRatings().stream()
                .map(this::getCatalogItem)
                .collect(Collectors.toList());
    }

    private CatalogItem getCatalogItem(Rating rating) {
        return Optional.of(movieInfoService.getMovieById(rating.getMovieId()))
                .map(movie -> new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating()))
                .orElse(new CatalogItem("Movie name not found", "", rating.getRating()));
    }
}
