package com.capgemini.molveno.restaurant.Order.PostGetDemo.Api;

import com.capgemini.molveno.restaurant.Order.PostGetDemo.Controller.DrinkService;
import com.capgemini.molveno.restaurant.Order.PostGetDemo.Model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("drink")
public class DrinkEndPoint {
    @Autowired
    private DrinkService drinkService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response stuurGet() {
        Iterable<Drink> drinks = drinkService.toonAlleDrinks();
        return javax.ws.rs.core.Response.ok(drinks).build();
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response stuurPost(Drink newDrink) {
        Drink drinks = drinkService.addNewDrink(newDrink);
        return javax.ws.rs.core.Response.accepted(drinks.getId()).build();
    }


}




