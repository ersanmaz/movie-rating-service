package org.movie.catalog.service;

import com.google.common.util.concurrent.UncheckedExecutionException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.movie.catalog.client.UserRatingServiceClient;
import org.movie.data.Rating;
import org.movie.data.UserRating;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RatingDataProvider {

    private final UserRatingServiceClient ratingService;

    public Rating getRatingByMovieId(String movieId) {
        try {
            return ratingService.getRatingByMovieId(movieId);
        } catch (FeignException e) {
            int status = e.status();
            if (406 == status) {
                log.error("TooManyResultsException:", e);
                throw new UncheckedExecutionException(e);
            } else {
                throw new RatingNotFoundException(e);
            }
        } catch (Exception e) {
            throw new RatingNotFoundException(e);
        }
    }

    public UserRating getRatingsByUserId(String userId) {
        return ratingService.getRatingsByUserId(userId);
    }
}
