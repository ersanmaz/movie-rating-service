package org.movie.catalog.service;

public class RatingNotFoundException extends RuntimeException {
    public RatingNotFoundException(Exception e) {
        super(e);
    }
}
