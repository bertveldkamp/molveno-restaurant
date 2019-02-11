package com.capgemini.molveno.restaurant.Order.controller;
import com.capgemini.molveno.restaurant.Order.model.Consumable;
import com.capgemini.molveno.restaurant.Order.model.Dish;
import com.capgemini.molveno.restaurant.Order.model.Ingredient;
import com.capgemini.molveno.restaurant.Order.model.MetaIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private  MetaIngredientRepository metaIngredientRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public Dish findByID(long id) {
        return dishRepository.findById(id).get();
    }

    public Dish save(Dish dish)
    {
//        System.out.println(dish.toString());
//        System.out.println(dish.getIngredientList());
//
//        Ingredient ingredient = new Ingredient("IngredientName","IngredientSupplier");
//        MetaIngredient metaIngredient = new MetaIngredient(150, MetaIngredient.UnitOfMeasurement.GRAM,ingredient);
//        ArrayList<MetaIngredient> metaIngredientArrayList = new ArrayList<>();
//        metaIngredientArrayList.add(metaIngredient);
//
//        Dish dishtest = new Dish("DishName","DishDescription",420,metaIngredientArrayList,"eencourse");
//
//        ingredientRepository.save(ingredient);
//        metaIngredientRepository.save(metaIngredient);
//        dishRepository.save(dishtest);
        

        return dish;
    }

    public Iterable<Dish> findAll() {
        return dishRepository.findAll();
    }
}