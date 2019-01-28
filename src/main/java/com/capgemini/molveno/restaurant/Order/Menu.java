package com.capgemini.molveno.restaurant.Order;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private List<Submenu> submenuList;

    public Menu(String name)
    {
        submenuList = new ArrayList<>();
        this.name = name;
    }

    public void show()
    {    }

    public boolean add(Submenu item)
    {
        return submenuList.add(item);
    }

    public boolean remove(Submenu item)
    {
        return submenuList.remove(item);

    }
    
    public String toString()
    {
        String str = "";
        for (Submenu item : this.submenuList)
        {
            str += item.toString() + "\n";
        }
        return str;
    }
}

