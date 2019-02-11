package com.capgemini.molveno.restaurant.Order.PostGetDemo.Config;

import com.capgemini.molveno.restaurant.Order.PostGetDemo.Api.DrinkEndPoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(DrinkEndPoint.class);
    }
}