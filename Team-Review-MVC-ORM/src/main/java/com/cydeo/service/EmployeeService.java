package com.cydeo.service;

import com.cydeo.dtos.EmployeeDTO;
import com.cydeo.entities.Employee;
import com.cydeo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(EmployeeDTO employeeDTO){
        Employee newEmployee = new Employee(employeeDTO);
        employeeRepository.save(newEmployee);
    }
}
