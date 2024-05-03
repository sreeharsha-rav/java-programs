package app.movies.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * This class is the model class for rating of a movie.
 * movieId: The ID of the movie.
 * rating: The rating of the movie.
 */
@Data
@AllArgsConstructor
public class Rating {

    private String movieId;
    private int rating;

}
