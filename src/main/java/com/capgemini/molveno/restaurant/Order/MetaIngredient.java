package com.capgemini.molveno.restaurant.Order;

import java.util.Objects;

public class MetaIngredient {
    public enum UnitOfMeasurement{
        GRAM,
        KILOGRAM,
        AMOUNT,
    }

    private int quantity;
    private UnitOfMeasurement unit;
    private Ingredient ingredient;

    public MetaIngredient(int quantity, UnitOfMeasurement unit,Ingredient ingredient) {
        this.quantity = quantity;
        this.unit = unit;
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return this.quantity + " " + this.unit.toString() + " " + this.ingredient.toString();
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UnitOfMeasurement getUnit() {
        return unit;
    }

    public void setUnit(UnitOfMeasurement unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaIngredient that = (MetaIngredient) o;
        return this.quantity == that.quantity &&
                this.ingredient.equals(that.ingredient) &&
                this.unit == that.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient, quantity, unit);
    }
}
