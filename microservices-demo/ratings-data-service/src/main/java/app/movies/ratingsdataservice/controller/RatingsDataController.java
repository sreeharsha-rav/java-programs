package app.movies.ratingsdataservice.controller;

import app.movies.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.*;

import app.movies.ratingsdataservice.model.Rating;

import java.util.Arrays;
import java.util.List;

/*
 * This class is a controller class for RatingsData
 * getRating: returns the rating of a movie
 * getUserRatings: returns the ratings of all movies rated by a user
 */
@RestController
@RequestMapping("/api/movies/ratings")
public class RatingsDataController {    // Server Port: 8200

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("123", 4),
                new Rating("456", 3)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }

}
