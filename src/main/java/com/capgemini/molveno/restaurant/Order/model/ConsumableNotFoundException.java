package com.capgemini.molveno.restaurant.Order.model;

public class ConsumableNotFoundException extends RuntimeException {
    private final String consumable;
    private final String menu;

    public ConsumableNotFoundException(String consumable, String menu) {
        this.consumable = consumable;
        this.menu = menu;
    }

    public String getConsumable() {
        return consumable;
    }

    public String getMenu() {
        return menu;
    }
}
