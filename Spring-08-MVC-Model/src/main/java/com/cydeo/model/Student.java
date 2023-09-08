package com.cydeo.model;


import lombok.AllArgsConstructor;
import lombok.Data;

// notice that component annotation is not needed.
// this isn't a dependency and will not have a dependency on a bean
@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
}
