package com.springboot.moviecatalogservice.resources;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.moviecatalogservice.models.CatalogItem;
import com.springboot.moviecatalogservice.models.Movie;
import com.springboot.moviecatalogservice.models.Rating;
import com.springboot.moviecatalogservice.models.UserRating;
import com.springboot.moviecatalogservice.service.MovieInfo;
import com.springboot.moviecatalogservice.service.UserRatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    MovieInfo movieInfo;

    @Autowired
    UserRatingInfo userRatingInfo;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRatings = userRatingInfo.getUserRating(userId);

        return userRatings.getRatings().stream().map(rating -> movieInfo.getCatalogItem(rating)
        ).collect(Collectors.toList());
    }
}

//Webclient

 /*Movie movie = webClientbuilder.build()
                            .get()
                            .uri("http://localhost:8082/movies/"+rating.getMovieId())
                            .retrieve()
                            .bodyToMono(Movie.class)
                            .block();*/
