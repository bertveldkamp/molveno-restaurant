package com.capgemini.molveno.restaurant.Order.controller;

import com.capgemini.molveno.restaurant.Order.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient findByID(long id) {
        return ingredientRepository.findById(id).get();
    }

    public Ingredient save(Ingredient ingredient)
    {
        return ingredientRepository.save(ingredient);
    }

    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }
}