package com.capgemini.molveno.restaurant.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @RequestMapping("/test")
    public String index(){
        return "Welcome to Molveno lake Resort";
    }
}
