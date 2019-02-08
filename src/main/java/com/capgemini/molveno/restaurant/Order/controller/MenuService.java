package com.capgemini.molveno.restaurant.Order.controller;
import com.capgemini.molveno.restaurant.Order.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Menu findByID(long id) {
        return menuRepository.findById(id).get();
    }

    public Iterable<Menu> findAll()
    {
        return menuRepository.findAll();
    }

    public Menu save(Menu menu)
    {
        return menuRepository.save(menu);
    }
}