package com.capgemini.molveno.restaurant.Order.view;

import javax.swing.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.capgemini.molveno.restaurant.Order.controller.DishService;
import com.capgemini.molveno.restaurant.Order.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

//@Path("/api/menu/")
//@Component
@RestController
@RequestMapping("/api/dish")
public class DishEndpoint {

    @Autowired
    private DishService dishService;

    @GetMapping("/all")
    public Iterable<Dish> listDishes(){
        return dishService.findAll();
    }

    @PostMapping("/add")
    public void addDish(@RequestBody Dish dish){
        dishService.save(dish);
    }

}