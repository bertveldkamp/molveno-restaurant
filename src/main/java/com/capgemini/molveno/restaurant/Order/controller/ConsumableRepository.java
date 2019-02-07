package com.capgemini.molveno.restaurant.Order.controller;

import com.capgemini.molveno.restaurant.Order.model.Consumable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ConsumableRepository extends CrudRepository <Consumable, Long>{

}