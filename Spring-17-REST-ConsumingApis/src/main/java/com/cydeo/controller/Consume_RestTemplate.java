package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/users")
public class Consume_RestTemplate {

    // define the URI that will be consumed API endpoint
    private final String URI = "https://jsonplaceholder.typicode.com/users";
    // inject the RestTemplate bean
    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // use Get mapping when consuming
    @GetMapping
    public User[] readAllUsers(){

        // can use RestTemplate Methods: getForEntity(), getForObject()

        // getForEntity takes as parameters the URI of the endpoint and what it will turn in to
        // Cannot use List, USE ARRAY
        // will call the endpoint, then will convert it to the specified type
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI, User[].class);

        return responseEntity.getBody();

        // thus, going to my endpoint localhost:9090/users will product the same output as the end point in URI
        // conceivably, you can use that information and generate a different response

    }

    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){
        // second RestTemplate method: getForObject()

        // getForObject takes as parameters


        String URL = URI+"/{id}";
        return restTemplate.getForObject(URL, Object.class, id);

    }
}
