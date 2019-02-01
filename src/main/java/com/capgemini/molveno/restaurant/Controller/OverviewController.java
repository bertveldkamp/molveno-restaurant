package com.capgemini.molveno.restaurant.Controller;

import com.capgemini.molveno.restaurant.Order.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/overview")
public class OverviewController {

    Menu menu;
    Overview totalOverview;
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
        Drink fanta = new Drink("Fanta",200,4,"Soft Drinks");
        menu.add(fanta);
        Drink sprite = new Drink("Sprite",200,4,"Soft Drinks");
        menu.add(sprite);

        order.addToOrder(tomatoSoup,1);

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
        private double price;
        private int amount;
        public OrderLine(String name, double price, int amount){
            this.name = name;
            this.price = price;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getAmount() {
            return amount;
        }
    }

    private void convertMapToList(Consumable item, int quantity, List<OrderLine> simpleOrderList){
        simpleOrderList.add(new OrderLine(item.getName(), item.getPrice(), quantity));
    }

    @PostMapping("/order")
    public void payOrconfider(){
        totalOverview.mergeOrders(order);
    }



}
