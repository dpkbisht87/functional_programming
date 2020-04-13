package com.springboot.movieinfoservice.resources;

import com.springboot.movieinfoservice.models.Movie;
import com.springboot.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        System.out.println("Api key:"+apiKey);
        System.out.println("movieId:"+movieId);

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(3000);

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId + "?api_key="+apiKey, MovieSummary.class);

        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}
