package com.capgemini.molveno.restaurant.Controller;

import com.capgemini.molveno.restaurant.Order.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@RestController
public class OverviewController {

    Menu menu;
    Overview order;

    @PostConstruct
    private void init()
    {
        order = new Overview();
    }

    @PostMapping("/addToOrder")
    public void addToOrder(@RequestParam String consumableName, @RequestParam int amount)
    {
       order.addToOrder(menu.getConsumable(consumableName),amount);
    }

    @PostMapping("/removeFromOrder")
    public void removeFromOrder(@RequestParam String consumableName)
    {
        order.removeFromOrder(menu.getConsumable(consumableName));
    }

    @GetMapping("/overview")
    public HashMap<Consumable, Integer> getOverview()
    {
        return order.getOverviewMap();
    }




}
