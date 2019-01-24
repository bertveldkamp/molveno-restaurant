package com.capgemini.molveno.restaurant;

import com.capgemini.molveno.restaurant.Order.Dish;
import com.capgemini.molveno.restaurant.Order.Drink;
import com.capgemini.molveno.restaurant.Order.Overview;

public class Restaurant {
    public static void main(String[] args){
        System.out.println("Welcome to the Molveno lake Resort restaurant.");
        Overview overview = new Overview();
        Overview order = new Overview();
        Drink cola = new Drink("Cola", 250, 2.00);
        Dish pasta = new Dish("Pasta", "Pasta", 2.00);
        order.addToOrder(cola);
        System.out.println("---Order--");
        order.printOverview();
        overview.addToOrder(pasta);
        System.out.println("\n---Overview--");
        overview.printOverview();
        System.out.println(order.confirmOrder(overview));
        System.out.println("\n---Order--");
        order.printOverview();
        System.out.println("\n---Overview--");
        overview.printOverview();
        System.out.println(order.confirmOrder(overview));
        System.out.println("\n---Overview--");
        overview.printOverview();


    }
}
