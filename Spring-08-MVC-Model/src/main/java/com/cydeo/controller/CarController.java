package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/info")  //localhost:8080/car/info?make=Honda&year=2015
    public String carInfo(@RequestParam(value="make",required = false) String make, @RequestParam(value="year", required = false, defaultValue = "2012") Integer year, Model model){
        System.out.println(make);
        System.out.println(year);


        model.addAttribute("make", make);
        model.addAttribute("year", year);
        return "car/car-info";
    }

    @RequestMapping("/info/{make}")  //localhost:8080/car/info/Honda
    public String getCarInfo(@PathVariable String make, Model model){
        System.out.println(make);


        model.addAttribute("make", make);
        return "car/car-info";
    }


}
