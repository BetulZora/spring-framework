package com.cydeo.controller;

import com.cydeo.entity.Genre;
import com.cydeo.entity.MovieCinema;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.MovieCinemaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    // WebClient uses a builder with a .baseUrl method you can use
    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:9090").build();

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

    //    @GetMapping("/mono-movie-cinema/{id}")
//    public Mono<MovieCinema> readById(@PathVariable("id") Long id){
//
//        return Mono.just(movieCinemaRepository.findById(id).get());
//
//    }

    @GetMapping("/mono-movie-cinema/{id}")
    public ResponseEntity<Mono<MovieCinema>> readByIdMono(@PathVariable("id") Long id){
        //return Mono.just(movieCinemaRepository.findById(id).get());
        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));
    }

    // for postmapping use requestbody
    @PostMapping("/create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre){

        Genre createdGenre = genreRepository.save(genre);
        return Mono.just(createdGenre);

        // return Mono.just(genreRepository.save(genre));
    }

    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){
        genreRepository.deleteById(id);
         return Mono.empty(); // use this if want to do a void return type with Mono
    }

    // -------------------------------------------------------------------------------
    // The following are WebClient methods
    // we will consume our own endpoints
    // use the WebClient object to consume

    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient(){
        return webClient
                .get() // choose http method
                .uri("/flux-movie-cinemas") // specify the endpoint we will consume
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) // pass headers if needed
                .retrieve()
                .bodyToFlux(MovieCinema.class); // supply the class we need to return as
    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id){
        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}", id) // will recognize the pathparam needed
                .retrieve()
                .bodyToMono(MovieCinema.class);

    }





}
