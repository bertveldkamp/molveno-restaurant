package com.capgemini.molveno.restaurant.Order.PostGetDemo.Controller;

import com.capgemini.molveno.restaurant.Order.PostGetDemo.Model.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface DrinkRepository extends CrudRepository<Drink, Long> {
}