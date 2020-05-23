package org.rating.data.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserRating {
    private List<Rating> ratings;
}
