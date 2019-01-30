package com.capgemini.molveno.restaurant;

import com.capgemini.molveno.restaurant.ReservationProposal;
import com.capgemini.molveno.restaurant.TablePlanner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDateTime;

import static org.junit.Assert.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
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
    table = new Table(4);


    //when


    //Then
    Assert.assertFalse(tablePlanner.availableSeats(tablePlanner));





}


    }
