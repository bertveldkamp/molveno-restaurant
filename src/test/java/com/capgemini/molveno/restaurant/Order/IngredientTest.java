package com.capgemini.molveno.restaurant.Order;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void equalstest() {
        Ingredient stroopwafel = new Ingredient("Stroopwafel","ACME Benelux");
        Ingredient stroopwafel2 = new Ingredient("Stroopwafel","ACME Benelux");
        Ingredient stroopwafel3 = new Ingredient("Stropwafel","ACME Benelux");
        Ingredient stroopwafel4 = new Ingredient("Stroopwafel","ACME Germany");

        Assert.assertTrue(stroopwafel.equals(stroopwafel));
        Assert.assertTrue(stroopwafel.equals(stroopwafel2));
        Assert.assertTrue(stroopwafel2.equals(stroopwafel));
        Assert.assertFalse(stroopwafel.equals(stroopwafel3));
        Assert.assertFalse(stroopwafel.equals(stroopwafel4));

    }

    @Test
    public void hashCodetest() {
        Ingredient stroopwafel = new Ingredient("Stroopwafel","ACME Benelux");
        Ingredient stroopwafel2 = new Ingredient("Stroopwafel","ACME Benelux");

        Assert.assertEquals(stroopwafel.hashCode(), stroopwafel2.hashCode());
        Assert.assertEquals(stroopwafel.hashCode(), stroopwafel.hashCode());
    }
}