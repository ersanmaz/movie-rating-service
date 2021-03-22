package org.movie.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CatalogItem {

    private final String name;
    private final String desc;
    private final int rating;
}
