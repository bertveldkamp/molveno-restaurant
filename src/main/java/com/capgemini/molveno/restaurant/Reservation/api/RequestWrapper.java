package com.capgemini.molveno.restaurant.Reservation.api;

import com.capgemini.molveno.restaurant.Reservation.ReservationProposal;
import com.capgemini.molveno.restaurant.Reservation.model.Guest;

public class RequestWrapper {
    Guest guest;
    ReservationProposal reservationProposal;

    RequestWrapper(Guest guest, ReservationProposal reservationProposal){
        this.guest = guest;
        this.reservationProposal = reservationProposal;
    }
}
