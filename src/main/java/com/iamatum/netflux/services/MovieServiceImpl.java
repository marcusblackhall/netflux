package com.iamatum.netflux.services;

import com.iamatum.netflux.domain.Movie;
import com.iamatum.netflux.domain.MovieEvent;
import com.iamatum.netflux.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

import static reactor.core.publisher.Flux.generate;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Mono<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Flux<MovieEvent> streamMovieEvents(String id) {

        return Flux.<MovieEvent>generate(s -> s.next(new MovieEvent(id, new Date())))
                .delayElements(Duration.ofSeconds(1));

    }
}
