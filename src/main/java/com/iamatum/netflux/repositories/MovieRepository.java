package com.iamatum.netflux.repositories;

import com.iamatum.netflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie,String> {
}
