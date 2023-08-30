package com.cydeo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private String name;

    // To do Dependency injection, I can put @Autowired here
    private Car car;

    // to do Dependency Injection: add @Autowired above:
    // I can also add it to a custom constructor ---> This is becoming the preferred way for Spring
    // or I can put it in a custom setter.
}
