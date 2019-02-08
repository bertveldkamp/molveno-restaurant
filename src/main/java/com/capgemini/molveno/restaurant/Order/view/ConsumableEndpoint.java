package com.capgemini.molveno.restaurant.Order.view;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.capgemini.molveno.restaurant.Order.controller.ConsumableService;
import com.capgemini.molveno.restaurant.Order.model.Consumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("api/consumable")
@Component
public class ConsumableEndpoint {

    @Autowired
    private ConsumableService consumableService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listConsumables(){
        Iterable <Consumable> consumables = consumableService.findAll();
        return Response.ok(consumables).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addConsumable(Consumable consumable){
        Consumable result = consumableService.save(consumable);
        return Response.accepted(result.getConsumableID()).build();
    }

}