package org.rating.data.controller;

import org.rating.data.entity.Rating;
import org.rating.data.entity.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @GetMapping("/{movieId}")
    public Rating getRatingByMovieId(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getRatingsByUserId(@PathVariable String userId) {
        List<Rating> ratings = Arrays.asList(new Rating("100", 4), new Rating("200", 3));
        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }
}
