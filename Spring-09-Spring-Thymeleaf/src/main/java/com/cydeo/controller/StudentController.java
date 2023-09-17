package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register"; // identifies the view (thymeleaf template)
    }

    // (optionally) capture student name from query param and use in the html
    @RequestMapping("/welcome")
    public String info(@RequestParam(value="name", required = false) String name, Model model){
        model.addAttribute("studentName", name);
        return "student/welcome";

        //TODO: redo the mentor-list exercise using th th iterator.
    }







}
