package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients // need this for FeignClient
public class Spring17RestConsumingApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring17RestConsumingApisApplication.class, args);
    }


    // RestTemplate, if used, needs to be used as a Bean
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
