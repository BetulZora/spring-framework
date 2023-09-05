package com.cydeo.stereotype_annotations.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (basePackages = "com.cydeo.stereotype_annotations.model")
public class HoursConfig {
}
