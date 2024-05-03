package app.movies.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/*
 * This class is the model class for the Movie.
 * movieId: The ID of the movie.
 * name: The name of the movie.
 */
@Data
@AllArgsConstructor
public class Movie {

    private String movieId;
    private String name;

}
