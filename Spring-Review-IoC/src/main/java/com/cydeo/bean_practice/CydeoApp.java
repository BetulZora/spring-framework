package com.cydeo.bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, AnotherConfig.class);

        // now execute the action of your bean
        // get it through the return type
        FullTimeEmployee fullTimeEmployee = context.getBean(FullTimeEmployee.class);

        fullTimeEmployee.createAccount();

        PartTimeEmployee pt = context.getBean(PartTimeEmployee.class);
        pt.createAccount();
        System.out.println(context.getBean("greeting", String.class));
        System.out.println(context.getBean( String.class));


    }
}
