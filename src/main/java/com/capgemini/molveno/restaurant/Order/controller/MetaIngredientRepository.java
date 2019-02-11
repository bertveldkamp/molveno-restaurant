package com.capgemini.molveno.restaurant.Order.controller;

import com.capgemini.molveno.restaurant.Order.model.MetaIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MetaIngredientRepository extends CrudRepository <MetaIngredient, Long>{

}