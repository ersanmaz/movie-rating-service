package org.movie.catalog.client;

import org.movie.service.MovieInfoService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "movie-info", fallbackFactory = MovieInfoServiceClientFallbackFactory.class)
public interface MovieInfoServiceClient extends MovieInfoService {
}
