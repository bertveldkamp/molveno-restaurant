package com.capgemini.molveno.restaurant.Order;

import java.util.ArrayList;
import java.util.List;

public class Submenu {
    private String name;
    private List <Consumable> consumableList;

    public Submenu (String name) {
        consumableList = new ArrayList<Consumable>();
        this.name = name;
    }


    public void show() {

    }
    public boolean add(Consumable item) {
        consumableList.add(item);

    }

    public boolean remove(Consumable item)
    {
        if (consumableList.contains(item))
        {
            consumableList.remove(item);
            return true;
        }
        else {
            return false;
        }
    }
}
