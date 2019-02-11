package com.capgemini.molveno.restaurant.Order.PostGetDemo.Controller;

import com.capgemini.molveno.restaurant.Order.PostGetDemo.Model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DrinkService
{
    @Autowired
    private DrinkRepository drinkRepository;

    public Iterable<Drink> toonAlleDrinks()
    {
        return drinkRepository.findAll();
    }

    public Drink addNewDrink(Drink newDrink)
    {
        return drinkRepository.save(newDrink);
    }
}