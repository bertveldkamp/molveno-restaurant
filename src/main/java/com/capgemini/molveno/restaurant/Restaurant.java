package com.capgemini.molveno.restaurant;

import com.capgemini.molveno.restaurant.Common.Controller.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Restaurant {
    public static void main(String[] args)
    {
        SpringApplication.run(Restaurant.class, args);

    }

    @Bean
    CommandLineRunner init(UserService userService) {
        return (args) -> userService.initUsers();
    }
}
