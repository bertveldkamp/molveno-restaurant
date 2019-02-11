package com.capgemini.molveno.restaurant.Order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class Drink{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long Id;
    String name;
    int volumeInMilliLiters;
    String description;
    double price;
    String course;

//    // Niet nodig???????????????????
//    public Drink_old(String name, int volumeInMilliLiters, String description,  double price, String course)
//    {
//        this.name = name;
//        this.volumeInMilliLiters = volumeInMilliLiters;
//        this.description = description;
//        this.price = price;
//        this.course = course;
//    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getVolumeInMilliLiters() {
        return volumeInMilliLiters;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCourse() {
        return course;
    }


    public void setId(long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolumeInMilliLiters(int volumeInMilliLiters) {
        this.volumeInMilliLiters = volumeInMilliLiters;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
