package com.capgemini.molveno.restaurant.Order;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private List<Submenu> submenuList;

    public Menu(String name) {
        submenuList = new ArrayList<>();
        this.name = name;
    }

    public void show() {

    }

    public boolean add(Submenu item) {
        submenuList.add(item);
        return true;
    }

    public boolean remove(Submenu item)
    {
        if (submenuList.contains(item))
        {
            submenuList.remove(item);
            return true;
        } else
            {
            return false;
            }
    }
}
