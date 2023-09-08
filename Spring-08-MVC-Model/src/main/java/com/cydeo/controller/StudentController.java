package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


        // let's add a subject attribute non statically
        String object = "Collections";
        model.addAttribute("subject", object);

        // create a random studentID and show it in the UI
        int studentID = new Random().nextInt();
        model.addAttribute("studentID", Integer.valueOf(studentID));

        // Can do a collection as well
        List<Integer> numbers = new ArrayList<>();
        numbers.add(40);
        numbers.add(400);
        numbers.add(4000);
        numbers.add(40000);
        model.addAttribute("faveNums", numbers);
        model.addAttribute("faveNum", numbers.get(2));

        // Lets deal with a custom POJO
        Student student = new Student(1,"Mike", "Smith");
        model.addAttribute("student", student);

        return "student/welcome";
        // do not need .html extention because using a thymeleaf file
    }






}
