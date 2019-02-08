package com.capgemini.molveno.restaurant.Order;

import com.capgemini.molveno.restaurant.Order.model.Bottle;
import com.capgemini.molveno.restaurant.Order.model.Drink;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BottleTest {

    @Test
    public void equalsTest() {
        Drink wine = new Drink("red red wine",150,"Red wine from Agartha, 2008BC", 200);
        Drink wine2 = new Drink("red red wine",150,"Red wine from Agartha, 2008BC", 200);
        Drink coke = new Drink("Cola",200,400,"Soft Drinks");

        Bottle wineBottle = new Bottle(wine,750,2000);
        Bottle wineBottle2 = new Bottle(wine,750,2000);
        Bottle wineBottle3 = new Bottle(wine2,750,2000);

        Bottle wineBottle4 = new Bottle(wine,700,2000);
        Bottle wineBottle5 = new Bottle(wine,750,2100);
        Bottle wineBottle6 = new Bottle(coke,750,2000);

        Assert.assertTrue(wineBottle.equals(wineBottle));
        Assert.assertTrue(wineBottle.equals(wineBottle2));
        Assert.assertTrue(wineBottle.equals(wineBottle3));
        Assert.assertTrue(wineBottle3.equals(wineBottle));
        Assert.assertFalse(wineBottle.equals(wineBottle4));
        Assert.assertFalse(wineBottle.equals(wineBottle5));
        Assert.assertFalse(wineBottle.equals(wineBottle6));
    }

    @Test
    public void hashCodeTest() {
        Drink wine = new Drink("red red wine",150,"Red wine from Agartha, 2008BC", 200);
        Drink wine2 = new Drink("red red wine",150,"Red wine from Agartha, 2008BC", 200);

        Bottle wineBottle = new Bottle(wine,750,2000);
        Bottle wineBottle2 = new Bottle(wine,750,2000);
        Bottle wineBottle3 = new Bottle(wine2,750,2000);


        Assert.assertEquals(wineBottle.hashCode(),wineBottle.hashCode());
        Assert.assertEquals(wineBottle.hashCode(),wineBottle2.hashCode());
        Assert.assertEquals(wineBottle.hashCode(),wineBottle3.hashCode());
    }
}