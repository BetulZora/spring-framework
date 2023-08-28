package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }

    @Bean
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }







}
