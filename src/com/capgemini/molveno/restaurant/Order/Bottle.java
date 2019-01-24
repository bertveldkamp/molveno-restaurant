package com.capgemini.molveno.restaurant.Order;

import java.util.Objects;

public class Bottle extends Drink {

    private Drink drink;

    Bottle(Drink drink,int bottleVolumeInMilliliters, double bottlePrice)
    {
        super(drink.getName(),bottleVolumeInMilliliters,bottlePrice);
        this.drink = drink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bottle bottle = (Bottle) o;
        return drink.equals(bottle.drink) && ((bottle.getName().equals(this.getName())) && (bottle.getDescription().equals(this.getDescription()) && (bottle.getPrice() == this.getPrice() && this.getVolumeInMilliLiters() == bottle.getVolumeInMilliLiters())));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), drink);
    }
}
