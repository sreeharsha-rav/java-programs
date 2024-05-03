package app.movies.moviecatalogservice.controller;

import app.movies.moviecatalogservice.model.CatalogItem;
import app.movies.moviecatalogservice.model.Movie;
import app.movies.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

/*
 * This class is the controller class for the Movie Catalog Service.
 * getCatalog(): This method is used to get the catalog of movies for a particular user.
 */
@RestController
@RequestMapping("/api/movies/catalog")
public class MovieCatalogController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    /*
     * This method is used to get the catalog of movies for a particular user.
     * @param userId: The ID of the user for which the catalog is to be fetched.
     * @return List<CatalogItem>: The list of catalog items for the user.
     * The method makes a call to the movie-info-service to get the movie details for each movie ID.
     */
    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        // get all rated movie IDs from ratings data service
        UserRating ratings = webClientBuilder.build()
                .get()
                .uri("http://ratings-data-service/api/movies/ratings/users/" + userId)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();
        // For each movie ID, call movie info service and get details
        return ratings.getUserRating().stream().map(rating -> {
            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://movie-info-service/api/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
            return new CatalogItem(movie.getName(), "Test", rating.getRating());
        })
                .collect(Collectors.toList());

    }

}
