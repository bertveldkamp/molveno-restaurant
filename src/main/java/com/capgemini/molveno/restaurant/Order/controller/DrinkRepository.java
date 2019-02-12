package com.capgemini.molveno.restaurant.Order.controller;

import com.capgemini.molveno.restaurant.Order.model.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface DrinkRepository extends CrudRepository<Drink, Long> {
}