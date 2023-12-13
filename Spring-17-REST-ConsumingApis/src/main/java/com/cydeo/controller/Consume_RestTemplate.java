package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


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

        // can use RestTemplate Methods: getForEntity(), getForObject(), exchange()

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

        // getForObject takes as parameters: 1)the URL endpoint with the path param concatenated
        // 2) Object.class
        // 3) the information to place into the path param dynamically
        String URL = URI+"/{id}";
        return restTemplate.getForObject(URL, Object.class, id);

    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumeFromDummyApi(){
        // third RestTemplate method: exchange()

        // especially use when credentials or headers are needed
        // exchange method takes as param: end point, HttpMethod (of the endpoint), HttpEntity, Object.class

        // first populate a HttpHeaders object.
        // second use the HttpHeaders object to create an HttpEntity<String> object.
        // third send the HttpEntity<String> object in the ResponseEntity<Object> object.

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

        return response;

    }
}
