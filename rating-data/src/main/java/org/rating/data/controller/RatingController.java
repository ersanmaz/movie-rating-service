package org.rating.data.controller;

import org.movie.data.Rating;
import org.movie.data.UserRating;
import org.movie.service.RatingService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RatingController implements RatingService {

    @Override
    public Rating getRatingByMovieId(@PathVariable String movieId) {
        //return new Rating(movieId, 4);
        //throw new UnsupportedOperationException("You cannot get rating!!!");
        throw new IllegalArgumentException("You cannot get rating!!!");
    }

    @Override
    public UserRating getRatingsByUserId(@PathVariable String userId) {
        List<Rating> ratings = Arrays.asList(new Rating("100", 4), new Rating("200", 3));
        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }
}
