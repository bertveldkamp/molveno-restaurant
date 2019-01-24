package com.capgemini.molveno.restaurant.Order;

import java.util.HashMap;

public class Overview {
    private final HashMap<Consumable, Integer> overviewMap;
    private double price;

    public Overview(){
        overviewMap = new HashMap<>();
        this.price = 0;
    }

    public void printOverview(){
        try {
            overviewMap.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public HashMap<Consumable, Integer> getOverviewMap() {
        return this.overviewMap;
    }
    public double getPrice(){
        return this.price;
    }

    public void addToOrder(Consumable item){
        int amount = 0;
        if(overviewMap.containsKey(item)){
            amount = overviewMap.get(item);
        }
        overviewMap.put(item, amount +1);
    }
    private void addToOrder(Consumable item, int quantity){
        for(int i = 1; i <= quantity; i++) {
            addToOrder(item);
        }
    }

    public boolean removeFromOrder(Consumable item){
        try {
            if (overviewMap.containsKey(item)) {
                int amount = overviewMap.get(item);
                if (amount > 1) {
                    overviewMap.put(item, amount - 1);
                    return true;
                } else if (amount == 1) {
                    overviewMap.remove(item);
                    return true;
                } else {
                    overviewMap.remove(item);
                    return false;
                }
            } else {
                return false;
            }
        }
        catch (NullPointerException e){
            return false;
        }
    }

    private boolean removeFromOrder(Consumable item, Integer quantity) {
        boolean returnValue = false;
        for(int i = 1; i <= quantity; i++) {
            returnValue = removeFromOrder(item);
            if(!returnValue) {
                return returnValue;
            }
        }
        return returnValue;
    }

    private boolean mergeOrders(Overview order){

        try {
            order.getOverviewMap().forEach(this::addToOrder);
        }
        catch (NullPointerException e){
            return false;
        }
        this.price += order.getPrice();
        return true;

    }

    public boolean confirmOrder(Overview orderOverview){
        //TODO Send to Kitchen Front End
        //TODO Send to Bar Front End
        boolean success = orderOverview.mergeOrders(this);
        try {
            this.overviewMap.forEach(this::removeFromOrder);
        }
        catch (NullPointerException e){
            return false;
        }
        return success;
    }

    public boolean payBill(){
        //TODO Generate PDF and EMAIL.
        return true;
    }
}
