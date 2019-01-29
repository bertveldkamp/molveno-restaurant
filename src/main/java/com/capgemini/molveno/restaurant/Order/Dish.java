package com.capgemini.molveno.restaurant.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dish extends  Consumable {
    private List<MetaIngredient> ingredientList;

    public Dish()
    {
        this.ingredientList = new ArrayList<MetaIngredient>(0);
    }

    public Dish(String name, String description, double price, List<MetaIngredient> ingredientList, String course) {
        super(name, description, price, course );
        this.ingredientList = ingredientList;
    }

    public Dish(String name, String description, double price, String course) {
        super(name, description, price, course );
        this.ingredientList = new ArrayList<MetaIngredient>(0);
    }

    public Dish(String name, String description, double price) {
        super(name, description, price, "" );
        this.ingredientList = new ArrayList<MetaIngredient>(0);
    }

    public Dish(String name, double price, String course) {
        super(name, "", price, course );
        this.ingredientList = new ArrayList<MetaIngredient>(0);
    }

    public boolean addIngredient(MetaIngredient ingredient)
    {
        return ingredientList.add(ingredient);
    }

    public boolean removeIngredient(MetaIngredient ingredient)
    {
        return ingredientList.remove(ingredient);
    }

    public List<MetaIngredient> getIngredientList() {
        return ingredientList;
    }

    @Override
    public String toString() {
        return getName() + " ￥" + getPrice() + ", " + getDescription() + " containing these ingredients: " + ingredientList.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dish dish = (Dish) o;
        return ingredientList.equals(dish.ingredientList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ingredientList);
    }
}
