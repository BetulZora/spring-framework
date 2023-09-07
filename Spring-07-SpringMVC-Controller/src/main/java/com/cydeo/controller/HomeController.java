package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // this stereotype annotation marks the controller
public class HomeController {

    @RequestMapping("/home") // The RequestMapping Annotation associcates the endpoint or HTTP request with a method
    public String home(){
        return "home.html"; // Return the html document name as string with display instructions
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome.html";
    }
    @RequestMapping
    public String welcome2(){
        return "welcome.html";
    }

//
//    // These have been moved to UserController.java
//    @RequestMapping("/user")
//    public String userInfo(){
//        return "user/userinfo.html";
//    }

}
