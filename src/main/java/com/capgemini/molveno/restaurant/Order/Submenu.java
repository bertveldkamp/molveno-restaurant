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


    public void show() {

    }
    public boolean add(Consumable item)
    {
        return consumableList.add(item);
    }

    public boolean remove(Consumable item)
    {
     return consumableList.remove(item);
        }

    public String toString()
    {
        String str = "" ;
        for (Consumable item: this.consumableList)
        {
            str += item.toString() + "\n";
        }
        return str;
    }
}
