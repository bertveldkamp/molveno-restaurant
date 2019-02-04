package com.capgemini.molveno.restaurant.Order;

import java.util.ArrayList;
import java.util.List;

public class Submenu {
    private String name;
    private List <Consumable> consumableList;

    public Submenu (String name) {
        consumableList = new ArrayList<>();
        this.name = name;
    }

    public boolean add(Consumable item) {
        return consumableList.add(item);
    }

    public boolean remove(Consumable item)
    {
       return consumableList.remove(item);
    }
}
