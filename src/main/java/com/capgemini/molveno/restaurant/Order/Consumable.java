package com.capgemini.molveno.restaurant.Order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Consumable {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private long id;
    private double price;
    private String name;
    private String description;
    private String course;

    //   private NumberFormat priceFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);

    public Consumable()
    {
        this.name = "";
        this.description = "";
        this.course = "";
    }

    public Consumable(String name, String description, double price)
    {
        this.price = price;
        this.name = name;
        this.description = description;
        this.course = "";
    }

    public Consumable(String name, String description, double price, String course)
    {
        this.price = price;
        this.name = name;
        this.description = description;
        this.course = course;
    }

    private void show()
    {
        System.out.println("Show");
    }

    @Override
    public String toString() {
        return name + " " + price + " " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumable that = (Consumable) o;
        return Double.compare(that.price, price) == 0 &&
                name.equals(that.name) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, description);
    }

    //Getters and Setters

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
