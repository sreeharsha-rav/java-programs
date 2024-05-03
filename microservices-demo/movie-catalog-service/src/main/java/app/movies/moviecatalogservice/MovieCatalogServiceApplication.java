package app.movies.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/*
 * This class is the main class for the Movie Catalog Service.
 * getWebClientBuilder(): This method is used to get the WebClient.Builder object.
 */
@SpringBootApplication
public class MovieCatalogServiceApplication {

	@Bean
	@LoadBalanced	// This annotation is used to make the WebClient.Builder object load balanced.
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
