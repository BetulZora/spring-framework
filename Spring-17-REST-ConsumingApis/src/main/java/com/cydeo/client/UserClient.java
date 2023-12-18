package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "USER-CLIENT")
public interface UserClient {
    // the URL specified in the annotation will be called in all methods included in this interface

    @GetMapping("/users") // will go to this end point of third party api
    List<User> getUsers(); // call this method in the controller
}
