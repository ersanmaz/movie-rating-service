package org.movie.catalog.client;

import feign.hystrix.FallbackFactory;
import org.movie.data.Rating;
import org.movie.data.UserRating;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

public class UserRatingServiceClientFallbackFactory implements FallbackFactory<UserRatingServiceClient> {
    @Override
    public UserRatingServiceClient create(Throwable throwable) {
        return new UserRatingServiceClient() {

            @Override
            public Rating getRatingByMovieId(String movieId) {
                return new Rating("0", 0);
            }

            @Override
            public UserRating getRatingsByUserId(String userId) {
                UserRating userRating = new UserRating();
                userRating.setUserId(userId);
                userRating.setRatings(Collections.singletonList(new Rating("0", 0)));
                return userRating;
            }
        };
    }
}
