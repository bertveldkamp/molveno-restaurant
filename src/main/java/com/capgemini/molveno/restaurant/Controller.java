package com.capgemini.molveno.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.capgemini.molveno.restaurant.Order.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {

    Menu menu;
    Overview order;

    @PostConstruct
    private void init()
    {
        menu = new Menu("menu");
        order = new Overview();

        menu.add(new Drink("Cola",200,4,"Soft Drinks"));
        Dish tomatoSoup = new Dish("Tomato Soup","Tomato soup from Italy",20,"Starter");
        tomatoSoup.addIngredient(new MetaIngredient(4, MetaIngredient.UnitOfMeasurement.KILOGRAM,new Ingredient("Tomato","ACME Italy")));
        tomatoSoup.addIngredient(new MetaIngredient(10, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Bassilicum","ACME Italy")));
        menu.add(tomatoSoup);
        order.addToOrder(tomatoSoup,1);
    }

    @PostMapping("/addDish")
    public void addDish(@RequestBody Dish dish)
    {
        menu.add(dish);
    }

    @PostMapping("/removeDish")
    public void removeDish(@RequestBody Dish dish)
    {
        menu.remove(dish);
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

    @GetMapping("/menu")
    public List<Consumable> getMenu()
    {
        return menu.getAllItems();
    }



}
