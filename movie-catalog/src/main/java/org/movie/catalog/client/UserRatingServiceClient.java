package org.movie.catalog.client;

import org.movie.data.Rating;
import org.movie.service.RatingService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "rating-data"/*, fallbackFactory = UserRatingServiceClientFallbackFactory.class*/)
public interface UserRatingServiceClient extends RatingService {

    /*@GetMapping("/ratings/{movieId}")
    ResponseEntity<Rating> getMovieRating(@PathVariable String movieId);*/
}
