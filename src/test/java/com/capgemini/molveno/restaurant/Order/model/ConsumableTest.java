package com.capgemini.molveno.restaurant.Order.model;

import com.capgemini.molveno.restaurant.Order.model.Consumable;
import org.junit.Assert;
import org.junit.Test;

public class ConsumableTest {

    @Test
    public void toStringTest() {
        //when
        Consumable stroopwafel = new Consumable("Stroopwafel","A refreshing treat from the Netherlands.",190);
        Consumable nothing = new Consumable();

        Assert.assertEquals("Stroopwafel 190.0 A refreshing treat from the Netherlands.",stroopwafel.toString());
        Assert.assertEquals(" 0.0 ",nothing.toString());

    }

    @Test
    public void equalsTest() {
        Consumable stroopwafel = new Consumable("Stroopwafel","A refreshing treat from the Netherlands.",190 );
        Consumable anotherstroopwafel = new Consumable("Stroopwafel","A refreshing treat from the Netherlands.",190 );
        Consumable expensiveStroopwafel = new Consumable("Stroopwafel","A refreshing treat from the Netherlands.",400 );
        Consumable typoStroopwafel = new Consumable("Stropwafel","A refreshing treat from the Netherlands.",190 );
        Consumable germanStroopwafel = new Consumable("Stroopwafel","A refreshing treat from Germany.",190 );
        Consumable applePie = new Consumable("Apple Pie","A delicious warm pie made from apples, seasoned with cinnamon and raisins.",400 );
        Consumable nothing = new Consumable();

        Assert.assertTrue(stroopwafel.equals(stroopwafel));
        Assert.assertTrue(anotherstroopwafel.equals(stroopwafel));
        Assert.assertTrue(stroopwafel.equals(anotherstroopwafel));
        Assert.assertTrue(nothing.equals(nothing));
        Assert.assertFalse(stroopwafel.equals(expensiveStroopwafel));
        Assert.assertFalse(stroopwafel.equals(typoStroopwafel));
        Assert.assertFalse(stroopwafel.equals(germanStroopwafel));
        Assert.assertFalse(stroopwafel.equals(applePie));

    }

    @Test
    public void hashCodeTest() {
        Consumable stroopwafel = new Consumable("Stroopwafel","A refreshing treat from the Netherlands.",190 );
        Consumable anotherstroopwafel = new Consumable("Stroopwafel","A refreshing treat from the Netherlands.",190 );


        Assert.assertEquals(stroopwafel.hashCode(),anotherstroopwafel.hashCode());

    }
}