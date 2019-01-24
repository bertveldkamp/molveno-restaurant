package com.capgemini.molveno.restaurant.Order;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkTest {

    @Test
    public void equalstest() {
        Drink coke = new Drink("Cola",200,400);
        Drink coke2 = new Drink("Cola",200,400);
        Drink coke3 = new Drink("Coka",200,400);
        Drink coke4 = new Drink("Cola",300,400);
        Drink coke5 = new Drink("Cola",200,500);

        Assert.assertTrue(coke.equals(coke2));
        Assert.assertTrue(coke2.equals(coke));
        Assert.assertFalse(coke.equals(coke3));
        Assert.assertFalse(coke.equals(coke4));
        Assert.assertFalse(coke.equals(coke5));
    }

    @Test
    public void hashCodetest() {
        Drink coke = new Drink("Cola",200,400);
        Drink coke2 = new Drink("Cola",200,400);

        Assert.assertEquals(coke.hashCode(),coke2.hashCode());
    }
}