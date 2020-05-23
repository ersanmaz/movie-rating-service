package org.movie.catalog.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.movie.catalog.entity.Rating;
import org.movie.catalog.entity.UserRating;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class UserRatingService {

    public static final String RATING_URL = "http://rating-data/ratings/users/";

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(String userId) {
        return restTemplate.getForObject(RATING_URL + userId, UserRating.class);
    }

    public UserRating getFallbackUserRating(String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        userRating.setRatings(Collections.singletonList(new Rating("0", 0)));
        return userRating;
    }
}
