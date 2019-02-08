package com.capgemini.molveno.restaurant.Order.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuID;

    @OneToMany
    private List<Consumable> consumableList;

    private String name;
    public Menu(String name) {
        consumableList = new ArrayList<Consumable>();
        this.name = name;
    }

    public boolean add(Consumable item) {
        return consumableList.add(item);
    }

    public boolean remove(Consumable item)
    {
        return consumableList.remove(item);
    }

    public List<Consumable> getAllItems()
    {
        //TODO consider making a copy
        return consumableList;
    }

    public List<Consumable> getCourse(String course)
    {
        List<Consumable> courseConsumables = new ArrayList<>();
        for(Consumable consumable: this.consumableList)
        {
            if(consumable.getCourse().equals(course))
            {
                courseConsumables.add(consumable);
            }
        }
        return courseConsumables;
    }

    public Consumable getConsumable(String consumableName) throws ConsumableNotFoundException
    {
        for(int i  = 0; i < consumableList.size(); ++i)
        {
            if(consumableList.get(i).getName().equals(consumableName))
            {
                return consumableList.get(i);
            }
        }
        throw new ConsumableNotFoundException(consumableName,this.name);
    }

    public long getMenuID() {
        return menuID;
    }

    public void setMenuID(long menuID) {
        this.menuID = menuID;
    }

    public List<Consumable> getConsumableList() {
        return consumableList;
    }

    public void setConsumableList(List<Consumable> consumableList) {
        this.consumableList = consumableList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
