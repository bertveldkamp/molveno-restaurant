package com.capgemini.molveno.restaurant.Order.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity

public class Drink_old extends Consumable {
    private int volumeInMilliLiters;

    //Needed for Spring MVC
    private Drink_old()
    {
        super();
    }

    public Drink_old(String name, int volumeInMilliLiters, double price, String course)
    {
        super(name,"",price, course);
        this.volumeInMilliLiters = volumeInMilliLiters;
    }
    public Drink_old(String name, int volumeInMilliLiters, double price)
    {
        super(name,"",price, "");
        this.volumeInMilliLiters = volumeInMilliLiters;
    }

    public Drink_old(String name, int volumeInMilliLiters, String description, double price, String course)
    {
        super(name,description,price, course );
        this.volumeInMilliLiters = volumeInMilliLiters;
    }

    public Drink_old(String name, int volumeInMilliLiters, String description, double price)
    {
        super(name,description,price, "" );
        this.volumeInMilliLiters = volumeInMilliLiters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drink_old drinkOld = (Drink_old) o;
        return volumeInMilliLiters == drinkOld.volumeInMilliLiters && ((drinkOld.getName().equals(this.getName())) && (drinkOld.getDescription().equals(this.getDescription()) && drinkOld.getPrice() == this.getPrice()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volumeInMilliLiters);
    }

    public int getVolumeInMilliLiters() {
        return volumeInMilliLiters;
    }

    public void setVolumeInMilliLiters(int volumeInMilliLiters) {
        this.volumeInMilliLiters = volumeInMilliLiters;
    }
}
