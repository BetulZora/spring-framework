package com.cydeo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan (basePackages = "com.cydeo")
@ComponentScan (basePackages = {"com.cydeo.proxy", "com.cydeo.service", "com.cydeo.repository"})
public class ProjectConfig {
}

//NOTE: it's a good idea to exclude plain POJO's (ones that will not be a bean)
// So we're excluding the model directory from the container with the basePackage