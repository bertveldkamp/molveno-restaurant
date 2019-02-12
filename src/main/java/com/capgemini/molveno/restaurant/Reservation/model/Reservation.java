package com.capgemini.molveno.restaurant.Reservation.model;

import com.capgemini.molveno.restaurant.Reservation.ReservationProposal;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne
    private Guest guest;
    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private int nrOfPeople;
    private int nrOfChildren;
    private boolean groupComplete = false;
    private int reservationNumber;

    @ManyToMany
    private List<Tablex> tablex = new ArrayList<Tablex>();

    public Reservation(){}

    public Reservation(ReservationProposal reservationProposal, Guest guest, List<Tablex> tablex){
        this.beginDateTime = reservationProposal.getBeginTime();
        this.endDateTime = this.beginDateTime.plusHours(2);
        this.nrOfPeople = reservationProposal.getNumberOfPeople();
        this.nrOfChildren = reservationProposal.getNumberOfChildren();
        this.reservationNumber = (int)(Math.random()*10000);
        this.guest = guest;
        this.tablex = tablex;
    }

    public List<Tablex> getTableId() {
        return tablex;
    }

    public LocalDateTime getBeginDateTime() {
        return beginDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public long getId() { return id; }

    public Guest getGuestId() { return guest; }

    public int getNrOfPeople() { return nrOfPeople; }

    public int getNrOfChildren() { return nrOfChildren; }

    public boolean isGroupComplete() { return groupComplete; }

    public int getReservationNumber() { return reservationNumber; }


}



