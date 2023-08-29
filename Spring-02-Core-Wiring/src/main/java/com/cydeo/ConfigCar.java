package com.cydeo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {

    @Bean
    Car car(){
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }
@Bean

    Person person(Car car){
        Person p = new Person();
        p.setName("Mike");
        // this is autowiring
        p.setCar(car);
        return p;
    }


    /*
    @Bean
    Person person(){
        Person p = new Person();
        p.setName("Mike");
        // this is direct wiring
        // call method in the method
        p.setCar(car());
        return p;
        }
     */


}
