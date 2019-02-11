package com.capgemini.molveno.restaurant.Order.controller;

import com.capgemini.molveno.restaurant.Order.model.MetaIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MetaIngredientService {

    @Autowired
    private MetaIngredientRepository metaingredientRepository;

    public MetaIngredient findByID(long id) {
        return metaingredientRepository.findById(id).get();
    }

    public MetaIngredient save(MetaIngredient ingredient)
    {
        return metaingredientRepository.save(ingredient);
    }

    public Iterable<MetaIngredient> findAll() {
        return metaingredientRepository.findAll();
    }
}