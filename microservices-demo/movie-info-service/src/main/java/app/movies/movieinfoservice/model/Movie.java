package app.movies.movieinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * This class is a model class for Movie
 * movieId: unique identifier for a movie
 * name: name of the movie
 */
@Data
@AllArgsConstructor
public class Movie {

    private String movieId;
    private String name;

}
