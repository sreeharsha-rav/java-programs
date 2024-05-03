package app.movies.movieinfoservice.controller;

import app.movies.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.*;

/*
 * This class is a controller class for MovieInfo
 * getMovieInfo: returns the information of a movie
 */
@RestController
@RequestMapping("/api/movies")
public class MovieInfoController { // Server Port: 8100s

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        return new Movie(movieId, "Transformers");
    }

}
