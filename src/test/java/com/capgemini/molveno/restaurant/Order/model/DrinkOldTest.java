package com.capgemini.molveno.restaurant.Order.model;

import org.junit.Assert;
import org.junit.Test;

public class DrinkOldTest {

    @Test
    public void equalstest() {
        Drink_old coke = new Drink_old("Cola",200,400);
        Drink_old coke2 = new Drink_old("Cola",200,400);
        Drink_old coke3 = new Drink_old("Coka",200,400);
        Drink_old coke4 = new Drink_old("Cola",300,400);
        Drink_old coke5 = new Drink_old("Cola",200,500);

        Assert.assertTrue(coke.equals(coke2));
        Assert.assertTrue(coke2.equals(coke));
        Assert.assertFalse(coke.equals(coke3));
        Assert.assertFalse(coke.equals(coke4));
        Assert.assertFalse(coke.equals(coke5));
    }

    @Test
    public void hashCodetest() {
        Drink_old coke = new Drink_old("Cola",200,400);
        Drink_old coke2 = new Drink_old("Cola",200,400);

        Assert.assertEquals(coke.hashCode(),coke2.hashCode());
    }
}