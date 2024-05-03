package app.movies.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * This class is the model class for the Catalog Item.
 * name: The name of the movie.
 * desc: The description of the movie.
 * rating: The rating of the movie.
 */
@Data
@AllArgsConstructor
public class CatalogItem {

    private String name;
    private String desc;
    private int rating;

}
