package com.capgemini.molveno.restaurant.Order.controller;
import com.capgemini.molveno.restaurant.Order.model.Consumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ConsumableService {

    @Autowired
    private ConsumableRepository consumableRepository;

    public Consumable findByID(long id) {
        return consumableRepository.findById(id).get();
    }

    public Consumable save(Consumable consumable)
    {
        return consumableRepository.save(consumable);
    }

    public Iterable<Consumable> findAll() {
        return consumableRepository.findAll();
    }
}