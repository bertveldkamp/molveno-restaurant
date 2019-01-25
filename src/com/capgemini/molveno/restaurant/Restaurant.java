package com.capgemini.molveno.restaurant;

import com.capgemini.molveno.restaurant.Order.*;

public class Restaurant {
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Molveno lake Resort restaurant.");
        System.out.println("Let me fetch you your menu");

        Menu foodMenu = new Menu("Molveno Restaurant Spring Menu 2019");
        Submenu startersSubMenu = new Submenu("Starters");
        Dish tomatoSoup = new Dish("Tomato Soup","Tomato soup from Italy",20);
        tomatoSoup.addIngredient(new MetaIngredient(4, MetaIngredient.UnitOfMeasurement.KILOGRAM,new Ingredient("Tomato","ACME Italy")));
        tomatoSoup.addIngredient(new MetaIngredient(10, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Bassilicum","ACME Italy")));

        startersSubMenu.add(tomatoSoup);
        foodMenu.add(startersSubMenu);
        //foodMenu.add(new Submenu("Main Course"));
        //foodMenu.add(new Submenu("Desserts"));

        Menu drinksMenu = new Menu("Molveno Restaurant Drinks Menu 2019");
        Submenu softDrinksSubMenu = new Submenu("Soft Drinks");
        Submenu winesSubMenu = new Submenu("Wines");
        Drink cola = new Drink("Coca Cola",330,4);
        Drink merlot = new Drink("Merlot",175,6);
        Bottle merlotBottle = new Bottle(merlot,750,20);

        drinksMenu.add(softDrinksSubMenu);
        drinksMenu.add(winesSubMenu);
        //drinksMenu.add(new Submenu("Hot Drinks"));
        //drinksMenu.add(new Submenu("Wines"));

        //menu.getSubMenu("Starters").add(new Dish("Tomato soup"))

        Overview overview = new Overview();

        overview.addToOrder(tomatoSoup);
        overview.addToOrder(cola);
        overview.getPrice();
        overview.addToOrder(merlotBottle);
        overview.addToOrder(merlot);
        overview.getPrice();

        overview.printOverview();
        overview.payBill();
    }
}
