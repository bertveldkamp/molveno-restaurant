package com.capgemini.molveno.restaurant.Order.controller;


import com.capgemini.molveno.restaurant.Order.model.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MenuRepository extends CrudRepository <Menu, Long>{


}