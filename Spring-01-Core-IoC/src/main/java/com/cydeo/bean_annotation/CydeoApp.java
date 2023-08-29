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


        // use the name attribute to differentiate between two @Bean methods that return
        // the same kind of object.
        // two @Bean s with names p1 and p2 return a PartTimeMentor object
        PartTimeMentor pt = container.getBean("p2", PartTimeMentor.class);
        PartTimeMentor pt1 = container.getBean( PartTimeMentor.class);

        ft.createAccount();
        pt.createAccount();
        pt1.createAccount();


        // Don't need custom POJOs can also use beans from ConfigAny

        String str = container.getBean(String.class);
        System.out.println(str);
    }
}
