package com.cydeo.controller;

import com.cydeo.entity.MovieCinema;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.MovieCinemaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class Consume_WebClient {

    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    // create a reactive end point using this
    // use Flux not List Mono rather than a single entity
    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllCinemaFlux(){

        // use Flux static methods to formulate the return statement
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }
}
