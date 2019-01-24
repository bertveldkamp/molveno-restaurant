package com.capgemini.molveno.restaurant.Order;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class Consumable {
    private double priceInYuan;
    private String name;
    private String description;
    //   private NumberFormat priceFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);

    public Consumable()
    {
        this.name = "";
        this.description = "";
    }

    public Consumable(String name, String description, double priceInYuan)
    {
        this.priceInYuan = priceInYuan;
        this.name = name;
        this.description = description;
    }

    private void show()
    {
        System.out.println("Show");
    }

    @Override
    public String toString() {
        return name + " " + priceInYuan + " " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumable that = (Consumable) o;
        return Double.compare(that.priceInYuan, priceInYuan) == 0 &&
                name.equals(that.name) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceInYuan, name, description);
    }

    //Getters and Setters

    public double getPrice() {
        return priceInYuan;
    }

    public void setPrice(double price) {
        this.priceInYuan = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
