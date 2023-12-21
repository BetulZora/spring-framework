package com.cydeo.controller;

import com.cydeo.entity.Cinema;
import com.cydeo.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Cinema", description = "Cinema CRUD Operations")
// use the @Tag annotation to populate name and description fields in the Swagger document. organizes all end points together in one tag.
public class CinemaController {

    private final CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }


    // use the @Operation annotation to describe the endpoint in the swagger document.
    @GetMapping("/cinemas")
    @Operation(summary = "Read all cinemas")
    public List<Cinema> readAllCinemas(){
        return cinemaRepository.findAll();
    }

}