package org.rating.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Rating {
    private final String movieId;
    private final int rating;
}
