package com.cydeo.stereotype_annotations;

import com.cydeo.stereotype_annotations.model.DataStructure;
import com.cydeo.stereotype_annotations.configurations.HoursConfig;
import com.cydeo.stereotype_annotations.model.Microservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoHourApp {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(HoursConfig.class);

        container.getBean(DataStructure.class).getTotalHours();
        container.getBean(Microservice.class).getTotalHours();



    }

}
