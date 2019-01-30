package com.capgemini.molveno.restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reservation {

    private Guest guest;
    private LocalDate date;
    private LocalTime time;
    private LocalTime endReservation;
    private int nrOfPeople;
    private int nrOfChildren;
    private boolean groupComplete = false;
    private int reservationNumber;
    private Table table;


    public Reservation(LocalDate datum,LocalTime time,int nrOfPeople,int nrOfChildren)

    public Guest getGuest() {
        return guest;this.date=datum;
        this.time=time;
        this.nrOfPeople=nrOfPeople;
        this.nrOfChildren=nrOfChildren;
        this.endReservation=time.plusHours(2);
        this.table = null; //moet gevuld worden vanuit TablePlanner
        this.reservationNumber = 1234;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalTime getEndReservation() {
        return endReservation;
    }

    public int getNrOfPeople() {
        return nrOfPeople;
    }

    public int getNrOfChildren() {
        return nrOfChildren;
    }

    public boolean isGroupComplete() {
        return groupComplete;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public Table getTable() {
        return table;
    }

    public LocalDateTime getBeginTime() {
        return time.atDate(date); }

    public LocalDateTime getEndTime() {
        return endReservation.atDate(date); }
}



