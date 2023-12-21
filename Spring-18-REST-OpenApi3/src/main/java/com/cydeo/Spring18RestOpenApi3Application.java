package com.cydeo;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring18RestOpenApi3Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring18RestOpenApi3Application.class, args);
    }


    // need this bean to modify the visual of Swagger documentation with openapi
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                // .components(new Components().addRequestBodies())  // use this method to populate the components in the yaml file
                // .servers()  // use this method to supply a list of server objects
                // .paths(new Paths().addPathItem("Some name", new PathItem().getGet().......)) // can use this method to define paths
                .info(new Info().title("Cinema Application OpenAPI").version("v1").description("Cinema application API documentation"));
        // this info method populates the info tag in the yaml file (title, version and description)
    }

}
