package com.cydeo.bean_practice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AnotherConfig {

    @Bean (name = "greeting")
String greeting(){
    return "Welcome to CydeoApp";


}

@Primary
@Bean(name = "topic")
String subjectStatement(){
    return "Spring Core Practice";
}
// NOTE: the method name can be used as a name too when calling in the runner
}
