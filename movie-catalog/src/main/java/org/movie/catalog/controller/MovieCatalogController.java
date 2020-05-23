package org.movie.catalog.controller;

import lombok.RequiredArgsConstructor;
import org.movie.catalog.entity.CatalogItem;
import org.movie.catalog.service.MovieInfoService;
import org.movie.catalog.service.UserRatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
@RequiredArgsConstructor
public class MovieCatalogController {

    private final UserRatingService userRatingService;
    private final MovieInfoService movieInfoService;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogByUserId(@PathVariable String userId) {
        return userRatingService.getUserRating(userId)
                .getRatings().stream()
                .map(movieInfoService::getCatalogItem)
                .collect(Collectors.toList());
    }
}
