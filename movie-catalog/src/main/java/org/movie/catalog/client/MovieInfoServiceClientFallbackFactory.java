package org.movie.catalog.client;

import feign.hystrix.FallbackFactory;
import org.movie.data.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieInfoServiceClientFallbackFactory implements FallbackFactory<MovieInfoServiceClient> {

    @Override
    public MovieInfoServiceClient create(Throwable throwable) {
        return movieId -> new Movie(movieId, "No movie", "No desc");
    }
}
