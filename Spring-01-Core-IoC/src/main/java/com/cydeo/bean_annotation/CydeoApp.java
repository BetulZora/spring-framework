package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        // Be sure that the pom.xml has the ContextApplication Container dependency
        // spring-context
        // org.springframework

        // Step1: Create the container.
        // Use ApplicationContext interface as reference for the container
        // Choose an implementation that matches the configuration set for the project
        // We chose Annotation ConfigApplicationContext() means we are using Configuration Annotations
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigAny.class);

        // Step2: Need Configurations need to be set
        // Use @Bean annotation for this package
        // The style of configuration will need to match the implementation of ApplicationContext
        // Pass the configuration class to the container instance.
        // If using more than one config class, can add that to the parameter



        // can now put beans in the container using the .getBean method and passing Type as parameter

        FullTimeMentor ft = container.getBean(FullTimeMentor.class);

        ft.createAccount();

    }
}
