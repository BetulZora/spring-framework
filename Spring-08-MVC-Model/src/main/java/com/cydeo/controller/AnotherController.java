package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/another")
public class AnotherController {

    // this end point is actually joint /another/list
    @RequestMapping("/list")
    public String mentorMethod(Model model){
        Mentor mentor1 = new Mentor("Mike", "Smith", 45, Gender.MALE);
        Mentor mentor2 = new Mentor("Tom", "Hanks", 65, Gender.MALE);
        Mentor mentor3 = new Mentor("Amy", "Bryan", 25, Gender.FEMALE);
        model.addAttribute("mentor1", mentor1 );
        model.addAttribute("mentor2", mentor2 );
        model.addAttribute("mentor3", mentor3 );

        List<Mentor> mentors = new ArrayList<>();
        mentors.add(mentor1);
        mentors.add(mentor2);
        mentors.add(mentor3);

        model.addAttribute("mentors", mentors);
        return "mentor/mentorList.html";
    }
}
