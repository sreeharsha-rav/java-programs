package app.movies.ratingsdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * This class is a model class for Rating
 * movieId: unique identifier for a movie
 * rating: rating of the movie
 */
@Data
@AllArgsConstructor
public class Rating {

    private String movieId;
    private int rating;

}
