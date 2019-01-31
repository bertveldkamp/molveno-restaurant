package com.capgemini.molveno.restaurant.Controller;

import com.capgemini.molveno.restaurant.Order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/overview")
public class OverviewController {

    Overview totalOverview;
    Overview order;

    Menu menu;

    @PostConstruct
    private void init()
    {
        totalOverview = new Overview();
        order = new Overview();
        menu = new Menu("test");
        menu.add(new Drink("Cola",200,4,"Soft Drinks"));
        Dish tomatoSoup = new Dish("Tomato Soup","Tomato soup from Italy",20,"Starter");
        tomatoSoup.addIngredient(new MetaIngredient(4, MetaIngredient.UnitOfMeasurement.KILOGRAM,new Ingredient("Tomato","ACME Italy")));
        tomatoSoup.addIngredient(new MetaIngredient(10, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Bassilicum","ACME Italy")));
        menu.add(tomatoSoup);
        order.addToOrder(tomatoSoup,1);
    }

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        return "overview.hml";
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

    @PostMapping("/payOrder")
    public void payOrder(@RequestParam String consumableName)
    {
        totalOverview.mergeOrders(order);
    }



}
