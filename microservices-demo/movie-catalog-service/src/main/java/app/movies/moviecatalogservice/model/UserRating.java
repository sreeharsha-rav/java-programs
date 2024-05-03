package app.movies.moviecatalogservice.model;

import lombok.Data;

import java.util.List;

/*
 * This class is the model class for the User Rating.
 * userRating: The list of ratings given by the user.
 */
@Data
public class UserRating {
    private List<Rating> userRating;
}
