package com.cydeo.controllers;

import com.cydeo.dtos.EmployeeDTO;
import com.cydeo.enums.State;
import com.cydeo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee-form")
    private String employeeform(Model model){

        model.addAttribute("employee", new EmployeeDTO());
        model.addAttribute("states", State.values());

        return "form";

    }

    @PostMapping("/employee")
    private String employeeSave(@ModelAttribute("employee") EmployeeDTO employeeDTO){

        employeeService.saveEmployee(employeeDTO);
        System.out.println("Saving in Controller: " + employeeDTO);


        return "redirect:/employee-form";
    }

}
