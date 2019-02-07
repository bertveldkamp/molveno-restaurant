package com.capgemini.molveno.restaurant.Order.view;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.capgemini.molveno.restaurant.Order.controller.MenuService;
import com.capgemini.molveno.restaurant.Order.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("api/menu")
@Component
public class MenuEndpoint {

    @Autowired
    private MenuService menuService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMenus(){
        Iterable <Menu> menus = menuService.findAll();
        return Response.ok(menus).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addMenu(Menu menu){
        Menu result = menuService.save(menu);
        return Response.accepted(result.getMenuID()).build();
    }

}