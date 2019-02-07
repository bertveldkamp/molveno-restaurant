package com.capgemini.molveno.restaurant.Order.controller;
import com.capgemini.molveno.restaurant.Order.model.Consumable;
import com.capgemini.molveno.restaurant.Order.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public Dish findByID(long id) {
        return dishRepository.findById(id).get();
    }

    public Dish save(Dish dish)
    {
        return dishRepository.save(dish);
    }

    public Iterable<Dish> findAll() {
        return dishRepository.findAll();
    }
}