package com.capgemini.molveno.restaurant.Order.view;

import com.capgemini.molveno.restaurant.Order.controller.DrinkService;
import com.capgemini.molveno.restaurant.Order.model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("api/drink")
public class DrinkEndPoint {
    @Autowired
    private DrinkService drinkService;

    @GetMapping
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response stuurGet() {
        Iterable<Drink> drinks = drinkService.toonAlleDrinks();
        return javax.ws.rs.core.Response.ok(drinks).build();
    }

    @PostMapping
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response stuurPost(@RequestBody @Valid Drink newDrink) {
        System.out.println(newDrink.getName());
        Drink drinks = drinkService.addNewDrink(newDrink);
        return javax.ws.rs.core.Response.accepted(drinks.getId()).build();
    }


}




