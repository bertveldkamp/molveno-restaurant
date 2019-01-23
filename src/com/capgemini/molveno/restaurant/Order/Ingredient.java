package com.capgemini.molveno.restaurant.Order;

import java.util.Objects;

public class Ingredient {
    private final String name;
    private String supplier;

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

    @Override
    public int hashCode() {
        return Objects.hash(name, supplier);
    }
}
