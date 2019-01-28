package com.capgemini.molveno.restaurant;

public class Table {

    private final int tableId;

    private int numberOfSeats;

    final TableType  type;


    public Table (int id, TableType type) {
        this.tableId = id;
        this.numberOfSeats = type.getValue();
        this.type = type;

    }




}

