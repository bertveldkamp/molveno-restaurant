package com.capgemini.molveno.restaurant.Reservation.model;

import javax.persistence.*;

@Entity
public class Tablex {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int numberOfSeats;

    @Enumerated(EnumType.STRING)
    private TableType  type;

    public Tablex(){}

    public Tablex(TableType type) {
        this.id = id;
        this.numberOfSeats = type.getValue();
        this.type = type;
    }

    public TableType getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}

