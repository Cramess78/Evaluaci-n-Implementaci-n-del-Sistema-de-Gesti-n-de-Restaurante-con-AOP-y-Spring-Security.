package com.cristian.restaurantegarcia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RestauranteGarciaApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestauranteGarciaApplication.class, args);
    }
}
