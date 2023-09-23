package com.cydeo.model;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mentor {

    public String firstName, lastName;
    public int age;
    public Gender gender;

    private String email;
    private String batch;
    private boolean graduated;
    private String company;


}
