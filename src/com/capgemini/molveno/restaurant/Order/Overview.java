package com.capgemini.molveno.restaurant.Order;

import java.util.HashMap;
import java.util.Map;

public class Overview {
    private HashMap<Consumable, Integer> overviewMap;
    private double price;

    public Overview(){
        overviewMap = new HashMap<Consumable, Integer>();
        this.price = 0;
    }
    public void showOverview(){

    }
    public boolean addToOrder(Consumable item){
        int ammount = 0;
        if(overviewMap.containsKey(item)){
            ammount = overviewMap.get(item);
        }
        overviewMap.put(item, ammount +1);
        return true;
    }
    public boolean removeFromOrder(Consumable item){
        if(overviewMap.containsKey(item)){
            int ammount = overviewMap.get(item);
            if(ammount > 1){
                overviewMap.put(item, ammount - 1);
                return true;
            }
            else if(ammount == 1){
                overviewMap.remove(item);
                return true;
            }
            else{
                overviewMap.remove(item);
                return false;
            }
        }
        else{
            return false;
        }
    }
    public boolean mergeOrders(HashMap<Consumable, Integer> test){
        return true;
    }
    public boolean confirmOrder(){
        return true;
    }
    public boolean payBill(){
        return true;
    }
}
