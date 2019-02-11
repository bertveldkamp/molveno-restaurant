package com.capgemini.molveno.restaurant.Order.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OverviewTest {
    Overview overview;

    @Before
    public void before(){
        overview = new Overview();
    }

    @Test
    public void addNoItemToEmptyMap(){
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        Map<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertFalse(hashMapContainsConsumable(testHashMap, testItem1));
    }

    @Test
    public void addItemToEmptyMap(){
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        overview.addToOrder(testItem1, 1);
        Map<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem1));
    }

    @Test
    public void addItemToFilledMap(){
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        Dish testItem2 = new Dish("Test2", "", 2.00);
        overview.addToOrder(testItem1, 1);
        overview.addToOrder(testItem2, 1);
        Map<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem1));
    }

    @Test
    public void addSameItemTwiceMap(){
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        overview.addToOrder(testItem1, 1);
        overview.addToOrder(testItem1, 1);
        HashMap<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem1));
        Assert.assertEquals(2, (long)testHashMap.get(testItem1));
    }

    @Test
    public void removeItemMap(){
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        overview.addToOrder(testItem1, 1);
        Assert.assertTrue(overview.removeFromOrder(testItem1));
        Map<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertFalse(hashMapContainsConsumable(testHashMap, testItem1));
    }

    @Test
    public void removeItemOnce(){
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        overview.addToOrder(testItem1, 1);
        overview.addToOrder(testItem1, 1);
        Assert.assertTrue(overview.removeFromOrder(testItem1));
        HashMap<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem1));
        Assert.assertEquals(1, (long)testHashMap.get(testItem1));
    }

    @Test
    public void removeItemTwice(){
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        overview.addToOrder(testItem1, 1);
        overview.addToOrder(testItem1, 1);
        HashMap<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem1));
        Assert.assertEquals(2, (long)testHashMap.get(testItem1));
        Assert.assertTrue(overview.removeFromOrder(testItem1));
        Assert.assertTrue(overview.removeFromOrder(testItem1));
        Assert.assertFalse(hashMapContainsConsumable(testHashMap, testItem1));
    }

    @Test
    public void removeDifferentItem(){
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        Dish testItem2 = new Dish("Test2", "", 2.00);
        overview.addToOrder(testItem1, 1);
        overview.addToOrder(testItem2, 1);
        HashMap<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem1));
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem2));

        overview.removeFromOrder(testItem1);
        Assert.assertFalse(hashMapContainsConsumable(testHashMap, testItem1));
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem2));
    }

    @Test
    public void removeNonExcistingItem(){
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        HashMap<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertFalse(hashMapContainsConsumable(testHashMap, testItem1));
    }

    @Test(expected = NullPointerException.class)
    public void addNullThrowNullPointer(){
        Drink_old testItem1 = null;
        overview.addToOrder(testItem1, 1);
    }

    @Test
    public void removeNullAndHandleException(){
        Drink_old testItem1 = null;
        Assert.assertFalse(overview.removeFromOrder(testItem1));
    }

    @Test
    public void mergeTwoOverviewsWithSameItem(){
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        overview.addToOrder(testItem1, 1);
        HashMap<Consumable, Integer> overviewHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(overviewHashMap, testItem1));

        Overview testOrder = new Overview();
        testOrder.addToOrder(testItem1, 1);
        HashMap<Consumable, Integer> orderHashMap = testOrder.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(orderHashMap, testItem1));

        overview.confirmOrder(testOrder);
        Assert.assertFalse(hashMapContainsConsumable(overviewHashMap, testItem1));
        Assert.assertTrue(hashMapContainsConsumable(orderHashMap, testItem1));
        Assert.assertEquals(2, (long)orderHashMap.get(testItem1));
    }

    @Test
    public void mergeTwoOverviewsWithDifferentItem(){
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        Dish testItem2 = new Dish("Test2", "", 2.00);
        overview.addToOrder(testItem1, 1);
        HashMap<Consumable, Integer> overviewHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(overviewHashMap, testItem1));

        Overview testOrder = new Overview();
        testOrder.addToOrder(testItem2, 1);
        HashMap<Consumable, Integer> orderHashMap = testOrder.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(orderHashMap, testItem2));

        overview.confirmOrder(testOrder);
        Assert.assertFalse(hashMapContainsConsumable(overviewHashMap, testItem1));
        Assert.assertTrue(hashMapContainsConsumable(orderHashMap, testItem1));
        Assert.assertEquals(1, (long)orderHashMap.get(testItem1));
        Assert.assertTrue(hashMapContainsConsumable(orderHashMap, testItem2));
        Assert.assertEquals(1, (long)orderHashMap.get(testItem2));
    }

    @Test
    public void calculateTotalPrice() {
        Drink_old testItem1 = new Drink_old("Test1", 250, 2.00);
        Dish testItem2 = new Dish("Test2", "", 2.00);
        overview.addToOrder(testItem1, 1);
        overview.addToOrder(testItem2, 1);
        HashMap<Consumable, Integer> overviewHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(overviewHashMap, testItem1));
        Assert.assertTrue(hashMapContainsConsumable(overviewHashMap, testItem2));
        Assert.assertEquals(4.00, overview.getPrice(), 0);
    }
    private boolean hashMapContainsConsumable(Map<Consumable, Integer> t_hashMap, Consumable item){
        return t_hashMap.containsKey(item);
    }

}
