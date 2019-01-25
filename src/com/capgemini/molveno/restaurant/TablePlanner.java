package com.capgemini.molveno.restaurant;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

        int numberOfPeople = reservationProposal.getNumberOfAdults() + reservationProposal.getNumberOfChildren();

        if (reservationProposal.checkValidity()
                && !availableTables(reservationProposal).isEmpty()
                && numberOfPeople <= availableSeats(reservationProposal)){
            return true;
            } else {
            return false;
        } 
    }

    public boolean isBetween(int x, int lower, int upper){
        return lower <= x && x <= upper;
    }

    List<Table> availableTables(ReservationProposal reservationProposal){
        List<Table> availableTables = tableList;
        LocalDateTime proposalTime = reservationProposal.getTime().atDate(reservationProposal.getDate());

        //Loop fills available table List
        for (Reservation reservation: reservationList) {

            LocalDateTime end = reservation.getEndReservation().atDate(reservation.getDate());
            LocalDateTime begin = reservation.getTime().atDate(reservation.getDate());

            if (proposalTime.isAfter(begin) && proposalTime.isBefore(end)){
                availableTables.remove(reservation.getTable());
            }
        }
        return availableTables;
    }

    int availableSeats(ReservationProposal reservationProposal){
        int seats = 0;

        for (Table table: availableTables(reservationProposal)) {
            seats = seats + table.type.getValue();
        }
    }


    public void addToTableList(Table table){
        tableList.add(table);
    }

    public void addToReservationList(Reservation reservation){
        reservationList.add(reservation);
    }
}
