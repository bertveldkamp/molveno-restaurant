package com.capgemini.molveno.restaurant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.capgemini.molveno.restaurant.Order.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    Menu menu;
    Overview order;

    @PostConstruct
    private void init()
    {
        menu = new Menu("menu");

        menu.add(new Drink("Cola",200,"  ",4,"Soft Drinks"));
        Dish tomatoSoup = new Dish("Tomato Soup","Tomato soup from Italy",20,"Starter");
        tomatoSoup.addIngredient(new MetaIngredient(4, MetaIngredient.UnitOfMeasurement.KILOGRAM,new Ingredient("Tomato","ACME Italy")));
        tomatoSoup.addIngredient(new MetaIngredient(10, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Bassilicum","ACME Italy")));
        menu.add(tomatoSoup);

    }

    @PostMapping("/addDish")
    public void addDish(@RequestBody Dish dish)
    {
        menu.add(dish);
    }

    @PostMapping("/addDrink")
    public void addDrink(@RequestBody Drink drink)
    {
        menu.add(drink);
    }

    @PostMapping("/removeConsumable")
    public void removeConsumable(@RequestBody String dish)
    {
        menu.remove(menu.getConsumable(dish));
    }

    @PostMapping("/removeDish")
    public void removeDish(@RequestBody Dish dish)
    {
        menu.remove(dish);
    }

    //TODO addDrink, addBottle



    @GetMapping("/menu")
    public List<Consumable> getMenu()
    {
        return menu.getAllItems();
    }



}
