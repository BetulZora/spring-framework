package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {


    // this end point is actually joint /mentor/list
    @RequestMapping("/list")
    public String mentorMethod(Model model){
        Mentor mentor1 = new Mentor("Mike", "Smith", 45, Gender.MALE,"mentor@cydeo.com", "B01", false, "Unknown");
        Mentor mentor2 = new Mentor("Tom", "Hanks", 65, Gender.MALE, "mentor@cydeo.com", "B01", false, "Unknown");
        Mentor mentor3 = new Mentor("Amy", "Bryan", 25, Gender.FEMALE, "mentor@cydeo.com", "B01", false, "Unknown");
        model.addAttribute("mentor1", mentor1 );
        model.addAttribute("mentor2", mentor2 );
        model.addAttribute("mentor3", mentor3 );

        List<Mentor> mentors = new ArrayList<>();
        mentors.add(mentor1);
        mentors.add(mentor2);
        mentors.add(mentor3);

        model.addAttribute("mentors", mentors);
        return "mentor/mentorList";
    }

    @GetMapping("/register")
    public String showForm1(Model model){
        // pass a new empty object to the view
        // fields of the mentor will be populated in the view.
        model.addAttribute("mentor", new Mentor());

        // In the final app, will load the batch list from a a place like a DB
        List<String> batchList = Arrays.asList("JD1", "JD2","EU1","EU2","B18","B28");
        model.addAttribute("batchList",batchList);

        return "mentor/mentor-register";
    }

    @PostMapping("/confirm")
    public String showForm2(@ModelAttribute("mentor") Mentor mentor){
        System.out.println(mentor.toString());

        // can use "mentor" in the html without needing to send it again

        return "mentor/mentor-confirmation";
        // return "redirect:/mentor/register";
        // when the app comes to /confirm endpoint, it shows the /mentor/register form again if you do redirect.


    }







}
