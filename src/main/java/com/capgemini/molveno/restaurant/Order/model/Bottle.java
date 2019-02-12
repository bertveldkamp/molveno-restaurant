package com.capgemini.molveno.restaurant.Order.model;

import java.util.Objects;

public class Bottle extends Drink_old {

    private Drink_old drinkOld;

    public Bottle(Drink_old drinkOld, int bottleVolumeInMilliliters, double bottlePrice)
    {
        super(drinkOld.getName(),bottleVolumeInMilliliters,bottlePrice, drinkOld.getCourse());
        this.drinkOld = drinkOld;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bottle bottle = (Bottle) o;
        return drinkOld.equals(bottle.drinkOld) && ((bottle.getName().equals(this.getName())) && (bottle.getDescription().equals(this.getDescription()) && (bottle.getPrice() == this.getPrice() && this.getVolumeInMilliLiters() == bottle.getVolumeInMilliLiters())));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), drinkOld);
    }
}
