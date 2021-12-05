package com.iamatum.netflux.bootstrap;

import com.iamatum.netflux.domain.Movie;
import com.iamatum.netflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class InitMovies implements CommandLineRunner {
    private final MovieRepository movieRepository;
    public InitMovies(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(
                        Flux.just("Silence of the lambdas",
                                        "Meet the fluxers",
                                        "The fluxinator",
                                        "Enter the Mono void",
                                        "Back to the Future",
                                        "Lord of the fluxxes"

                                ).map(Movie::new)
                                .flatMap(movieRepository::save)

                ).subscribe(null, null,
                        () -> movieRepository.findAll().subscribe(s ->
                                System.out.println(s.getTitle())
                        ));


    }
}
