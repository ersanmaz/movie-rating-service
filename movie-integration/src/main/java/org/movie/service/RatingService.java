package org.movie.service;

import org.movie.data.Rating;
import org.movie.data.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface RatingService {
    @GetMapping("/ratings/{movieId}")
    Rating getRatingByMovieId(@PathVariable String movieId);

    @GetMapping("/ratings/users/{userId}")
    UserRating getRatingsByUserId(@PathVariable String userId);
}
