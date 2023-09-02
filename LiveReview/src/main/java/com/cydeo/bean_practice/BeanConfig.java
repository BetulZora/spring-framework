package com.cydeo.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    FullTimeEmployee getFullTimeEmployee(){
        return new FullTimeEmployee();
    }

    @Bean
    PartTimeEmployee getPartTimeEmployee(){
        return new PartTimeEmployee();
    }


}
