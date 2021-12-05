package com.iamatum.netflux.controllers;

import com.iamatum.netflux.domain.Movie;
import com.iamatum.netflux.domain.MovieEvent;
import com.iamatum.netflux.services.MovieService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("movies")
public class MovieController {
   private MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public Mono<Movie> getMovieById(@PathVariable String id){

        return movieService.getMovieById(id);

    }

    @GetMapping()
    Flux<Movie> getAllMovies(){

        return movieService.getAllMovies();

    }

    @GetMapping(value = "/{id}/events",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEvent> streamMovieEvets(@PathVariable String id){

        return movieService.streamMovieEvents(id);

    }



}
