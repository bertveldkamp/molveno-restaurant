package com.capgemini.molveno.restaurant.Reservation;

import com.capgemini.molveno.restaurant.Order.*;

import java.util.HashMap;

public class Printer {
    private static final Printer printer = new Printer();

    Printer()
    {

    }

    public Printer getInstance()
    {
        return this.printer;
    }

    public static void sendtoPrinter(HashMap<Consumable, Integer> orderMap,int tableID)
    {
        orderMap.forEach((consumable, amount) -> {
            if(consumable instanceof Drink)
            {
                System.out.printf("Order for the bar - %i %s \n",amount, consumable.getName());
            } else if(consumable instanceof Dish) {
                System.out.printf("Order for the kitchen - %i %s \n",amount, consumable.getName());
            } else {
                // TODO - make nice exception to show an adequate level of panic.
                System.out.println("WOW GUYS SOMETHING IS GOING TERRIBLY WRONG HERE WHAT");
            }
        });
    }
}
