package com.capgemini.molveno.restaurant.Controller;

import com.capgemini.molveno.restaurant.Order.model.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/overview")
public class OverviewController {

    Menu menu;
    Overview totalOverview;
    Overview order;

    @PostConstruct
    @GetMapping("/demo")
    private void init()
    {
        menu = new Menu("menu");
        order = new Overview();
        totalOverview = new Overview();

        menu.add(new Drink("Cola",200,4,"Soft Drink"));
        Dish tomatoSoup = new Dish("Tomato Soup","Tomato soup from Italy",20,"Starter");
        tomatoSoup.addIngredient(new MetaIngredient(200, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Tomato","Italy")));
        tomatoSoup.addIngredient(new MetaIngredient(10, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Basil","Italy")));
        menu.add(tomatoSoup);
        Drink fanta = new Drink("Fanta",333,4,"Soft Drink");
        menu.add(fanta);
        Drink sprite = new Drink("Sprite",333,4,"Soft Drink");
        menu.add(sprite);
        Drink vermentino = new Drink("Vermentino", 200,"Vermentino from Sardegna, Italy", 6, "Spirit");
        Bottle vermentinoBottle = new Bottle(vermentino, 1000, 30);
        Dish salmon = new Dish("Salmon Fillet", "Pan seared salmon fillet.", 30, "Main Course");
        salmon.addIngredient(new MetaIngredient(200, MetaIngredient.UnitOfMeasurement.GRAM, new Ingredient("Salmon", "Italy")));
        Dish herbRoastedPotatoes = new Dish("Herb Roasted Potatoes", "Potatoes roasted in the oven with goose fat and rosemary", 5, "Side Dish");
        herbRoastedPotatoes.addIngredient(new MetaIngredient(350, MetaIngredient.UnitOfMeasurement.GRAM, new Ingredient("Red Potato", "the Netherlands")));
        herbRoastedPotatoes.addIngredient(new MetaIngredient(2, MetaIngredient.UnitOfMeasurement.AMOUNT, new Ingredient("Rosemary", "Homegrown")));
        herbRoastedPotatoes.addIngredient(new MetaIngredient(25, MetaIngredient.UnitOfMeasurement.GRAM, new Ingredient("Goose fat", "Germany")));

        Dish asparagus = new Dish("Grilled Asparagus", "Asparagus grilled in a pan with a bit of olive oil. Asparagus are finished with a pinch of salt and freshly cracked black pepper.", 10, "Side Dish");
        asparagus.addIngredient(new MetaIngredient(450, MetaIngredient.UnitOfMeasurement.GRAM, new Ingredient("Asparagus", "Denmark")));

        order.addToOrder(vermentinoBottle,1);
        order.addToOrder(salmon, 2);
        order.addToOrder(herbRoastedPotatoes, 1);
        order.addToOrder(asparagus, 1);

        totalOverview.addToOrder(fanta, 1);
        totalOverview.addToOrder(sprite, 1);
        totalOverview.addToOrder(tomatoSoup, 2);

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
    public List<OrderLine> getOverview()
    {
        HashMap<Consumable, Integer> complexOrderMap = totalOverview.getOverviewMap();
        List<OrderLine> simpleOrderList = new ArrayList<>();
        complexOrderMap.forEach((key, value) -> convertMapToList(key, value, simpleOrderList));
        return simpleOrderList;
    }

    @GetMapping("/order")
    public List<OrderLine> getOrder()
    {
        HashMap<Consumable, Integer> complexOrderMap = order.getOverviewMap();
        List<OrderLine> simpleOrderList = new ArrayList<>();
        complexOrderMap.forEach((key, value) -> convertMapToList(key, value, simpleOrderList));
        return simpleOrderList;
    }

    private class OrderLine{
        private String name;
        private String course;
        private double price;
        private int amount;
        public OrderLine(String name, String course, double price, int amount){
            this.name = name;
            this.course = course;
            this.price = price;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public String getCourse(){
            return course;
        }

        public double getPrice() {
            return price;
        }

        public int getAmount() {
            return amount;
        }
    }

    private void convertMapToList(Consumable item, int quantity, List<OrderLine> simpleOrderList){
        simpleOrderList.add(new OrderLine(item.getName(), item.getCourse(), item.getPrice(), quantity));
    }

    @PostMapping("/confirmOrder")
    public void confirmOrder(){
        order.confirmOrder(totalOverview);
    }



}
