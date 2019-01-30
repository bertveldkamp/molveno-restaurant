package com.capgemini.molveno.restaurant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Singleton Tableplanner
public class TablePlanner {

    private static final TablePlanner tablePlanner = new TablePlanner();

    private final List<Table> tableList;
    private final List<Reservation> reservationList;

    private TablePlanner(){
        this.tableList = new ArrayList<>();
        this.reservationList = new ArrayList<>();
    }

    /**
     * Singleton pattern
     */
    public static TablePlanner getInstance(){
        return tablePlanner;
    }


    public boolean checkAvailable(ReservationProposal reservationProposal) throws InvalidProposalException{

        if (!reservationProposal.checkValidity())
        {
            InvalidProposalException invalidProposalException = new InvalidProposalException();
            throw invalidProposalException;
        }

        int numberOfPeople = reservationProposal.getNumberOfPeople();

        return !availableTables(reservationProposal).isEmpty() && numberOfPeople <= availableSeats(reservationProposal);

    }

    List<Table> availableTables(ReservationProposal reservationProposal){
        List<Table> availableTables = tableList;
        LocalDateTime proposalBeginTime = reservationProposal.getBeginTime();
        LocalDateTime proposalEndTime = reservationProposal.getEndTime();

        //Loop fills available table List
        for (Reservation reservation: reservationList) {

            LocalDateTime end = reservation.getEndReservation().atDate(reservation.getDate());
            LocalDateTime begin = reservation.getTime().atDate(reservation.getDate());


            if (dateIsBetween(proposalBeginTime, begin, end) || dateIsBetween(proposalEndTime, begin, end)){
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
        return seats;
    }


    public void addToTableList(Table table){
        tableList.add(table);
    }

    public void addToReservationList(Reservation reservation){
        reservationList.add(reservation);
    }

    public boolean intIsBetween(int x, int lower, int upper){
        return lower <= x && x <= upper;
    }

    private boolean dateIsBetween(LocalDateTime x, LocalDateTime begin, LocalDateTime end){
        return begin.isBefore(x) && x.isBefore(end);
    }
}
