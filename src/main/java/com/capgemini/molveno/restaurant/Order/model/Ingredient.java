package com.capgemini.molveno.restaurant.Order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ingredientID;

    private String name;
    private String supplier;

    private Ingredient()
    {
    }

    public Ingredient(String name, String supplier) {
        this.name = name;
        this.supplier = supplier;
    }

    public String toString() {
        return name + " from " + supplier ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return this.name.equals(that.name) &&
                this.supplier.equals(that.supplier);
    }

    public String getName() {
        return name;
    }

    public String getSupplier() {
        return supplier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, supplier);
    }
}
