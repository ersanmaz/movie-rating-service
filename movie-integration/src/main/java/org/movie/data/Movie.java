package org.movie.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movie {
    private final String movieId;
    private final String name;
    private final String description;
}
