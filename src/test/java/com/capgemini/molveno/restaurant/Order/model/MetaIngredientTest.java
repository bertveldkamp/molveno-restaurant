package com.capgemini.molveno.restaurant.Order.model;

import com.capgemini.molveno.restaurant.Order.model.Ingredient;
import com.capgemini.molveno.restaurant.Order.model.MetaIngredient;
import org.junit.Assert;
import org.junit.Test;

public class MetaIngredientTest {

    //Getters and Setters are presumed to work, as well as the toString

    @Test
    public void equalsTest() {
        Ingredient stroopwafel = new Ingredient("Stroopwafel","ACME Benelux");
        Ingredient stroopwafel2 = new Ingredient("Stroopwafel","ACME Benelux");
        Ingredient rozeKoek = new Ingredient("Roze Koek","ACME Benelux");


        MetaIngredient stroopwafelpak = new MetaIngredient(10, MetaIngredient.UnitOfMeasurement.AMOUNT,stroopwafel);
        MetaIngredient stroopwafelpak2 = new MetaIngredient(10, MetaIngredient.UnitOfMeasurement.AMOUNT,stroopwafel2);
        MetaIngredient stroopwafelpak3 = new MetaIngredient(5, MetaIngredient.UnitOfMeasurement.AMOUNT,stroopwafel);
        MetaIngredient stroopwafelpak4 = new MetaIngredient(10, MetaIngredient.UnitOfMeasurement.GRAM,stroopwafel);
        MetaIngredient stroopwafelpak5 = new MetaIngredient(10, MetaIngredient.UnitOfMeasurement.AMOUNT,rozeKoek);
        MetaIngredient stroopwafelpak6 = new MetaIngredient(5, MetaIngredient.UnitOfMeasurement.GRAM,rozeKoek);
        stroopwafelpak6.setIngredient(stroopwafel);
        stroopwafelpak6.setQuantity(10);
        stroopwafelpak6.setUnit(MetaIngredient.UnitOfMeasurement.AMOUNT);

        Assert.assertTrue(stroopwafelpak.equals(stroopwafelpak2));
        Assert.assertTrue(stroopwafelpak2.equals(stroopwafelpak));
        Assert.assertTrue(stroopwafelpak.equals(stroopwafelpak6));
        Assert.assertFalse(stroopwafelpak.equals(stroopwafelpak3));
        Assert.assertFalse(stroopwafelpak.equals(stroopwafelpak4));
        Assert.assertFalse(stroopwafelpak.equals(stroopwafelpak5));
    }

    @Test
    public void hashCodeTest() {
        Ingredient stroopwafel = new Ingredient("Stroopwafel","ACME Benelux");
        Ingredient stroopwafel2 = new Ingredient("Stroopwafel","ACME Benelux");
        Ingredient rozeKoek = new Ingredient("Roze Koek","ACME Benelux");

        MetaIngredient stroopwafelpak = new MetaIngredient(10, MetaIngredient.UnitOfMeasurement.AMOUNT,stroopwafel);
        MetaIngredient stroopwafelpak2 = new MetaIngredient(10, MetaIngredient.UnitOfMeasurement.AMOUNT,stroopwafel2);
        MetaIngredient stroopwafelpak3 = new MetaIngredient(5, MetaIngredient.UnitOfMeasurement.GRAM,rozeKoek);
        stroopwafelpak3.setIngredient(stroopwafel);
        stroopwafelpak3.setQuantity(10);
        stroopwafelpak3.setUnit(MetaIngredient.UnitOfMeasurement.AMOUNT);

        Assert.assertEquals(stroopwafelpak.hashCode(),stroopwafelpak.hashCode());
        Assert.assertEquals(stroopwafelpak2.hashCode(),stroopwafelpak.hashCode());
        Assert.assertEquals(stroopwafelpak3.hashCode(),stroopwafelpak.hashCode());
    }
}