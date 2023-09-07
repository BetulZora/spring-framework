package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homepage(Model model){

        // Need a Model Instance given as a parameter
        // Use of Model methods will allow usage of custom data

        // Add attributes to our html
        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");

        // the thymeleaf template will utilize the attributes

        return "student/welcome";
        // do not need .html extention becuase using a thymeleaf file
    }






}
