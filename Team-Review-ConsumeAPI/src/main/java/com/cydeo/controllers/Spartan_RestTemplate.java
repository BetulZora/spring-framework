package com.cydeo.controllers;


import com.cydeo.entity.Spartan;
import com.cydeo.repository.SpartanRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/my-spartans")
public class Spartan_RestTemplate {

    public final String url = "http://54.173.31.211:8000/api/spartans";

    private final RestTemplate restTemplate;
    private final SpartanRepository spartanRepository;

    public Spartan_RestTemplate(RestTemplate restTemplate, SpartanRepository spartanRepository) {
        this.restTemplate = restTemplate;
        this.spartanRepository = spartanRepository;
    }

    @GetMapping("/import-spartans")
    public Object getStuff(){

        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/import-spartans2")
    public Spartan[] getStuff2(){

        Spartan[] spartanArray =restTemplate.getForEntity(url, Spartan[].class).getBody();

        spartanRepository.saveAll(Arrays.asList(spartanArray));

        return spartanArray;
    }

    @GetMapping("getSpartan/{id}")
    public Spartan getSpartan(@PathVariable("id") Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Spartan> response = restTemplate.exchange((url+"/{id}"), HttpMethod.GET,entity,Spartan.class,id);

        Spartan myEntity = response.getBody();

        spartanRepository.save(myEntity);


        return myEntity;
    }





}
