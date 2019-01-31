package com.capgemini.molveno.restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reservation {

    private Guest guest;
    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private int nrOfPeople;
    private int nrOfChildren;
    private boolean groupComplete = false;
    private int reservationNumber;
    private Table table;


    public Reservation(ReservationProposal reservationProposal, Guest guest, Table table){
        this.beginDateTime = reservationProposal.getBeginTime();
        this.endDateTime = this.beginDateTime.plusHours(2);
        this.nrOfPeople = reservationProposal.getNumberOfPeople();
        this.nrOfChildren = reservationProposal.getNumberOfChildren();
        this.reservationNumber = 1234;
        this.guest = guest;
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public LocalDateTime getBeginDateTime() {
        return beginDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
}



