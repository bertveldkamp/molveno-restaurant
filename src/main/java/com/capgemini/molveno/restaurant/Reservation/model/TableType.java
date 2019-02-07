package com.capgemini.molveno.restaurant.Reservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public enum TableType {


    RoundTable(12),
    SquareTable(4);

    private final int value;

    TableType(int value) {
        this.value= value;
    }

    public int getValue() {return value;}

}



