package app.movies.ratingsdataservice.model;

import lombok.Data;

import java.util.List;

/*
 * This class is a model class for UserRating
 * userRating: list of ratings of all movies rated by a user
 */
@Data
public class UserRating {
    private List<Rating> userRating;
}
