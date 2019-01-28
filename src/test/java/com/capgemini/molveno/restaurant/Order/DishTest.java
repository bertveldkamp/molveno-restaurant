package com.capgemini.molveno.restaurant.Order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DishTest {

    @Test
    public void addIngredient() {
        MetaIngredient macaroni = new MetaIngredient(125, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Macaroni","ACME Italy"));
        MetaIngredient cheese = new MetaIngredient(150, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Cheese","ACME USA"));

        Dish macNCheese = new Dish("Mac 'n Cheese","Macaroni with cheese",800,new ArrayList<MetaIngredient>(0));
        macNCheese.addIngredient(macaroni);
        macNCheese.addIngredient(cheese);

        List<MetaIngredient> macNCheeseIngredientList2 = new ArrayList<MetaIngredient>(0);
        macNCheeseIngredientList2.add(macaroni);
        macNCheeseIngredientList2.add(cheese);

        Assert.assertEquals(macNCheeseIngredientList2,macNCheese.getIngredientList());

    }

    @Test
    public void removeIngredient() {
        MetaIngredient macaroni = new MetaIngredient(125, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Macaroni","ACME Italy"));
        MetaIngredient cheese = new MetaIngredient(150, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Cheese","ACME USA"));

        Dish macNCheese = new Dish("Mac 'n Cheese","Macaroni with cheese",800,new ArrayList<MetaIngredient>(0));
        macNCheese.addIngredient(macaroni);
        macNCheese.addIngredient(cheese);

        macNCheese.removeIngredient(cheese);

        List<MetaIngredient> macNCheeseIngredientList2 = new ArrayList<MetaIngredient>(0);
        macNCheeseIngredientList2.add(macaroni);

        Assert.assertEquals(macNCheeseIngredientList2,macNCheese.getIngredientList());

    }

    @Test
    public void getIngredientList() {
        MetaIngredient macaroni = new MetaIngredient(125, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Macaroni","ACME Italy"));
        MetaIngredient cheese = new MetaIngredient(150, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Cheese","ACME USA"));

        Dish nothing = new Dish();
        Dish applePie = new Dish("Apple Pie",400);
        Dish macNCheese = new Dish("Mac 'n Cheese","Macaroni with cheese",800,new ArrayList<MetaIngredient>(0));
        macNCheese.addIngredient(macaroni);
        macNCheese.addIngredient(cheese);

        ArrayList<MetaIngredient> macNCheeseIngredientList = new ArrayList<MetaIngredient>(0);
        macNCheeseIngredientList.add(macaroni);
        macNCheeseIngredientList.add(cheese);

        List<MetaIngredient> macNCheeseIngredientList2 = new ArrayList<MetaIngredient>(0);
        macNCheeseIngredientList2.add(macaroni);
        macNCheeseIngredientList2.add(cheese);

        Assert.assertEquals(macNCheeseIngredientList,macNCheese.getIngredientList());
        Assert.assertEquals(macNCheeseIngredientList2,macNCheese.getIngredientList());
        Assert.assertTrue(nothing.getIngredientList().isEmpty());
        Assert.assertTrue(applePie.getIngredientList().isEmpty());


    }

    @Test
    public void equalsTest() {
        MetaIngredient macaroni = new MetaIngredient(125, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Macaroni","ACME Italy"));
        MetaIngredient cheese = new MetaIngredient(150, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Cheese","ACME USA"));

        Dish macNCheese = new Dish("Mac 'n Cheese","Macaroni with cheese",800,new ArrayList<MetaIngredient>(0));
        macNCheese.addIngredient(macaroni);
        macNCheese.addIngredient(cheese);

        Dish macNCheese2 = new Dish("Mac 'n Cheese","Macaroni with cheese",800,new ArrayList<MetaIngredient>(0));
        macNCheese2.addIngredient(macaroni);
        macNCheese2.addIngredient(cheese);

        Dish nothing = new Dish();

        Assert.assertTrue(macNCheese.equals(macNCheese2));
        Assert.assertTrue(macNCheese2.equals(macNCheese));
        Assert.assertFalse(macNCheese2.equals(nothing));

    }

    @Test
    public void hashCodeTest() {
        MetaIngredient macaroni = new MetaIngredient(125, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Macaroni","ACME Italy"));
        MetaIngredient cheese = new MetaIngredient(150, MetaIngredient.UnitOfMeasurement.GRAM,new Ingredient("Cheese","ACME USA"));

        Dish macNCheese = new Dish("Mac 'n Cheese","Macaroni with cheese",800,new ArrayList<MetaIngredient>(0));
        macNCheese.addIngredient(macaroni);
        macNCheese.addIngredient(cheese);

        Dish macNCheese2 = new Dish("Mac 'n Cheese","Macaroni with cheese",800,new ArrayList<MetaIngredient>(0));
        macNCheese2.addIngredient(macaroni);
        macNCheese2.addIngredient(cheese);

        Assert.assertEquals(macNCheese.hashCode(),macNCheese2.hashCode());
    }
}