package com.capgemini.molveno.restaurant;

public enum TableType {
    RoundTable(12),
    SquareTable(4);

    private final int value;

    TableType(int value) {
        this.value= value;
    }

    public int getValue() {return value;}

}



