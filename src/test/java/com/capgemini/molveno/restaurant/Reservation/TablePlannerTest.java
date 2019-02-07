/*
package com.capgemini.molveno.restaurant.Reservation;


import com.capgemini.molveno.restaurant.Reservation.ReservationProposal;
import com.capgemini.molveno.restaurant.Reservation.model.Tablex;
import com.capgemini.molveno.restaurant.Reservation.control.TablePlanner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;
import java.time.LocalTime;

public class TablePlannerTest {

    TablePlanner tablePlanner;
    ReservationProposal reservationProposal;


    @Before
    public void initialize() {
        tablePlanner = new TablePlanner();

    }

    @Test
    public void checkAvailableWithInvalidReservation() {
        //Given
        reservationProposal = new ReservationProposal();
        reservationProposal.setNumberOfAdults(0);
        reservationProposal.setDate(LocalDate.now());
        reservationProposal.setTime(LocalTime.now());


        //When


        //Then
        Assert.assertFalse(tablePlanner.checkAvailable(reservationProposal));

    }

    @Test
    public void checkMoreNumberOfAdults(){
        //Given
        tablePlanner = new TablePlanner();
        reservationProposal.setNumberOfAdults(8);
        reservationProposal.setNumberOfChildren(7);
        int availalbleSeats = 12;
        table = new Tablex(4);


        //when


        //Then
        Assert.assertFalse(tablePlanner.availableSeats(tablePlanner));





    }


}
 */