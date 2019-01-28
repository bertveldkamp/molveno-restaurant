package com.capgemini.molveno.restaurant.Order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OverviewTest {
    private Overview overview;

    @Before
    public void before(){
        overview = new Overview();
    }

    @Test
    public void addNoItemToEmptyMap(){
        Drink testItem1 = new Drink("Test1", 250, 2.00);
        Map<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertFalse(hashMapContainsConsumable(testHashMap, testItem1));
    }

    @Test
    public void addItemToEmptyMap(){
        Drink testItem1 = new Drink("Test1", 250, 2.00);
        overview.addToOrder(testItem1, 1);
        Map<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem1));
    }

    @Test
    public void addItemToFilledMap(){
        Drink testItem1 = new Drink("Test1", 250, 2.00);
        Dish testItem2 = new Dish("Test2", "", 2.00);
        overview.addToOrder(testItem1, 1);
        overview.addToOrder(testItem2, 1);
        Map<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem1));
    }

    @Test
    public void addSameItemTwiceMap(){
        Drink testItem1 = new Drink("Test1", 250, 2.00);
        overview.addToOrder(testItem1, 1);
        overview.addToOrder(testItem1, 1);
        HashMap<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem1));
        Assert.assertEquals(2, (long)testHashMap.get(testItem1));
    }

    @Test
    public void removeItemMap(){
        Drink testItem1 = new Drink("Test1", 250, 2.00);
        overview.addToOrder(testItem1, 1);
        Assert.assertTrue(overview.removeFromOrder(testItem1));
        Map<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertFalse(hashMapContainsConsumable(testHashMap, testItem1));
    }

    @Test
    public void removeItemOnce(){
        Drink testItem1 = new Drink("Test1", 250, 2.00);
        overview.addToOrder(testItem1, 1);
        overview.addToOrder(testItem1, 1);
        Assert.assertTrue(overview.removeFromOrder(testItem1));
        HashMap<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(testHashMap, testItem1));
        Assert.assertEquals(1, (long)testHashMap.get(testItem1));
    }

    @Test
    public void removeItemTwice(){
        Drink testItem1 = new Drink("Test1", 250, 2.00);
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
        Drink testItem1 = new Drink("Test1", 250, 2.00);
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
    public void removeNonExistingItem(){
        Drink testItem1 = new Drink("Test1", 250, 2.00);
        HashMap<Consumable, Integer> testHashMap = overview.getOverviewMap();
        Assert.assertFalse(hashMapContainsConsumable(testHashMap, testItem1));
    }

    @Test
    public void mergeTwoOverviewsWithSameItem(){
        Drink testItem1 = new Drink("Test1", 250, 2.00);
        overview.addToOrder(testItem1, 1);
        HashMap<Consumable, Integer> overviewHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(overviewHashMap, testItem1));

        Overview testOrder = new Overview();
        testOrder.addToOrder(testItem1, 1);
        HashMap<Consumable, Integer> orderHashMap = testOrder.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(orderHashMap, testItem1));

        overview.mergeOrders(testOrder);
        Assert.assertTrue(hashMapContainsConsumable(overviewHashMap, testItem1));
        Assert.assertEquals(2, (long)overviewHashMap.get(testItem1));
    }

    @Test
    public void mergeTwoOverviewsWithDifferentItem(){
        Drink testItem1 = new Drink("Test1", 250, 2.00);
        Dish testItem2 = new Dish("Test2", "", 2.00);
        overview.addToOrder(testItem1, 1);
        HashMap<Consumable, Integer> overviewHashMap = overview.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(overviewHashMap, testItem1));

        Overview testOrder = new Overview();
        testOrder.addToOrder(testItem2, 1);
        HashMap<Consumable, Integer> orderHashMap = testOrder.getOverviewMap();
        Assert.assertTrue(hashMapContainsConsumable(orderHashMap, testItem2));

        overview.mergeOrders(testOrder);
        Assert.assertTrue(hashMapContainsConsumable(overviewHashMap, testItem1));
        Assert.assertEquals(1, (long)overviewHashMap.get(testItem1));
        Assert.assertTrue(hashMapContainsConsumable(overviewHashMap, testItem2));
        Assert.assertEquals(1, (long)overviewHashMap.get(testItem2));
    }

    @Test
    public void calculateTotalPrice() {
        Drink testItem1 = new Drink("Test1", 250, 2.00);
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
