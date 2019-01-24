package com.capgemini.molveno.restaurant;

import java.util.List;

//Singleton Tabelplanner
public class TablePlanner {

    private static final TablePlanner tablePlanner = new TablePlanner();

    private List<Table> tableList;
    private List<Reservation> reservationList;

    private TablePlanner(){
    }

    public static TablePlanner getInstance(){
        return tablePlanner;
    }

    public boolean checkAvailable(ReservationProposal reservationProposal){
        for (Reservation reservation: reservationList) {

            reservation.getEndReservation().atDate(reservation.getDate());
            reservation.getTime().atDate(reservation.getDate());
        }
    }

    public void addToTableList(Table table){
        tableList.add(table);
    }

    public void addToReservationList(Reservation reservation){
        reservationList.add(reservation);
    }
}
