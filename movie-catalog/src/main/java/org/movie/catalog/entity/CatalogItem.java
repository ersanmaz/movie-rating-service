package org.movie.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CatalogItem {

    private final String name;
    private final String desc;
    private final int rating;
}
