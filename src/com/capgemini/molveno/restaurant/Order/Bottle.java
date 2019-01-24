package com.capgemini.molveno.restaurant.Order;

public class Bottle extends Drink {

    Drink drink;

    Bottle(Drink drink,int bottleVolumeInMilliliters, double price)
    {
        super(drink.getName(),bottleVolumeInMilliliters,price);
        this.drink = drink;
    }

}
