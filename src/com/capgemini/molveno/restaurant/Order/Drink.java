package com.capgemini.molveno.restaurant.Order;

import java.util.Objects;

public class Drink extends Consumable {
    private int volume;

    public Drink(String name,int volume, double price)
    {
        setName(name);
        this.volume = volume;
        setPrice(price);
    }

    public Drink(String name,int volume, String description, double price)
    {
        setName(name);
        this.volume = volume;
        setPrice(price);
    }

    public boolean isBottle()
    {
        return this.volume >= 0.5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drink drink = (Drink) o;
        return volume == drink.volume && (drink.getName() == this.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }
}
