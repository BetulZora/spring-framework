package com.cydeo.stereotype_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        // Java class that we want beans from will have @Component

        // the configuration file must be marked with:
        // 2 annotations: @Configuration and @ComponentScan

        // Need a container first
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCourse.class);

        // Spring will automatically look for @Component classes and will immediately add to container as bean

        context.getBean(Java.class).getTeachingHours();




    }
}
