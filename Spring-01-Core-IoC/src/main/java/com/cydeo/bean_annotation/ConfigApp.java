package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigApp {

    // CAN HAVE MORE THAN ONE CLASS THAT IS MARKED AS @CONFIGURATION


    /*
    Define a configuration class (annotated with @Configuration).
    Add to the configuration class a method that returns the object instance
    that you want to add to the context and annotate the method with the
    @Bean annotation.
    Make Spring use the configuration class defined in the first step
     */



    // When more than one @Bean method returns the same type of object, it has to be handled
    @Bean
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }

    @Bean //(name = "p1")
    @Primary
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }


    // can differentiate  the annotation by the name attribute
    @Bean (name = "p2")
    PartTimeMentor partTimeMentor2(){
        return new PartTimeMentor();
    }





}
