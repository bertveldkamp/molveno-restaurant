package com.capgemini.molveno.restaurant.Reservation.config;

import com.capgemini.molveno.restaurant.Reservation.api.Controller;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/restaurant")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(Controller.class);
    }
}
