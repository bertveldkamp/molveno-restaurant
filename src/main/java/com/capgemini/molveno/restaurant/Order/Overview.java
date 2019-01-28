package com.capgemini.molveno.restaurant.Order;

import java.util.HashMap;

public class Overview {
    private final HashMap<Consumable, Integer> overviewMap;
    private double price;

    public Overview(){
        overviewMap = new HashMap<>(0);
        this.price = 0;
    }

    public void printOverview(){
        //TODO Remove once front end has been made.
        overviewMap.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
    }

    public HashMap<Consumable, Integer> getOverviewMap() {
        return this.overviewMap;
    }

    public double getPrice(){
        return this.price;
    }

    public void addToOrder(Consumable item, int quantity) {
        int amount = 0;
        if(overviewMap.containsKey(item)){
            amount = overviewMap.get(item);
        }
        price += item.getPrice();
        overviewMap.put(item, amount + quantity);
    }

    public boolean removeFromOrder(Consumable item) {
        if (overviewMap.containsKey(item)) {
            int amount = overviewMap.get(item);
            if (amount > 1) {
                overviewMap.put(item, amount - 1);
                price -= item.getPrice();
                return true;
            } else if (amount == 1) {
                overviewMap.remove(item);
                price -= item.getPrice();
                return true;
            } else {
                overviewMap.remove(item);
                this.price = 0;
                overviewMap.forEach(this::calculatePricePerItem);
                return false;
            }
        } else {
            return false;
        }
    }
    private void calculatePricePerItem(Consumable item, int amount){
        this.price += amount * item.getPrice();
    }

    public boolean mergeOrders(Overview order) {
        order.getOverviewMap().forEach(this::addToOrder);
        this.price += order.getPrice();
        return true;

    }

    public boolean confirmOrder(Overview orderOverview){
        //TODO Send to Kitchen Front End
        //TODO Send to Bar Front End
        boolean success = orderOverview.mergeOrders(this);
        overviewMap.clear();

        return success;
    }

    public boolean payBill(){
        //TODO Generate PDF and EMAIL.
        return true;
    }
}
