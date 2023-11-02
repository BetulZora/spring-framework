package com.cydeo.entities;

import com.cydeo.dtos.EmployeeDTO;
import com.cydeo.enums.State;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Column(columnDefinition = "DATE")
    private LocalDate birthDay;
    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private String email;
    private String password;
    private String address;
    private String address2;
    private String City;
    @Enumerated(EnumType.STRING)
    private State state;
    private String zipCode;

    public Employee(EmployeeDTO employeeDTO){
        setFirstName(employeeDTO.getFirstName());
        setLastName(employeeDTO.getLastName());
        setCity(employeeDTO.getCity());
        setAddress(employeeDTO.getAddress());
        setAddress2(employeeDTO.getAddress2());
        setState(employeeDTO.getState());
        setZipCode(employeeDTO.getZipCode());
        setEmail(employeeDTO.getEmail());
        setPassword(employeeDTO.getPassword());
        setBirthDay(employeeDTO.getBirthDay());
        setCreatedDate(LocalDate.now());
    }



}
