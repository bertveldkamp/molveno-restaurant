//package com.capgemini.molveno.restaurant.Order.controller;
//
//import com.capgemini.molveno.restaurant.Order.model.Consumable;
//import com.capgemini.molveno.restaurant.Order.model.Dish;
//import com.capgemini.molveno.restaurant.Order.model.Drink_old;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class ConsumableServiceTest {
//
//    @Test
//    public void save() {
//        ConsumableService consumableService = new ConsumableService();
//        Consumable consumable = new Consumable("consumableName","consumableDescription",4, "consumableCourse");
//        Dish dish = new Dish("DishName","DishDescription",9,"DishCourse");
//        Drink_old drink = new Drink_old("DrinkName",420,4.20,"DrinkCourse");
//
//        Consumable savedConsumable = consumableService.save(consumable);
//        Dish savedDish = (Dish) consumableService.save(dish);
//        Drink_old savedDrink = (Drink_old) consumableService.save(drink);
//
//        Assert.assertEquals(consumable,savedConsumable);
//        Assert.assertEquals(dish,savedDish);
//        Assert.assertEquals(drink,savedDrink);
//
//    }
//
//    @Test
//    public void findByID() {
//        ConsumableService consumableService = new ConsumableService();
//
//        consumableService.save(new Consumable());
//
//        long id = 0;
//        Consumable consumable = consumableService.findByID(id);
//
//        long id2 = -1;
//        Consumable consumable2 = consumableService.findByID(id2);
//
//        long id3 = 99999999;
//        Consumable consumable3 = consumableService.findByID(id3);
//
//        Assert.assertEquals(id,consumable.getConsumableID());
//        Assert.assertNull(consumable2);
//        Assert.assertNull(consumable3);
//    }
//
//    @Test
//    public void findAllTest(){
//        ConsumableService consumableService = new ConsumableService();
//        Collection<Consumable> emptyConsumables = (Collection<Consumable>) consumableService.findAll();
//
//        consumableService.save(new Consumable());
//
//        Collection<Consumable> oneConsumable = (Collection<Consumable>) consumableService.findAll();
//
//        Assert.assertEquals(0,emptyConsumables.size());
//        Assert.assertEquals(1,oneConsumable.size());
//    }
//}