package com.capgemini.molveno.restaurant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationProposalTest {

    ReservationProposal reservationProposal;
    LocalDate date;
    LocalTime time;
    int numberOfAdults;

    @Before
    public void initialize(){
        reservationProposal = new ReservationProposal();

    }

    @Test
    public void checkAvailable() {
        //Given
        //When
        //Then
    }

    @Test
    public void checkValidityTrue() {
        //Given
        date = LocalDate.of(2019, 6, 12);
        time = LocalTime.of(18, 30);
        numberOfAdults = 4;

        reservationProposal.setDate(date);
        reservationProposal.setTime(time);
        reservationProposal.setNumberOfAdults(numberOfAdults);

        //When
        reservationProposal.checkValidity();

        //Then
        Assert.assertTrue(reservationProposal.isValidProposal());
    }

    @Test
    public void checkValidityFalseDate(){
        //Given
        date = LocalDate.of(2018, 6, 12);
        time = LocalTime.of(18, 30);
        numberOfAdults = 4;

        reservationProposal.setDate(date);
        reservationProposal.setTime(time);
        reservationProposal.setNumberOfAdults(numberOfAdults);

        //When
        reservationProposal.checkValidity();

        //Then
        Assert.assertTrue(reservationProposal.isValidProposal());
    }

    @Test
    public void checkValidityNoAdults(){
        //Given
        date = LocalDate.of(2019, 6, 12);
        time = LocalTime.of(18, 30);
        numberOfAdults = 0;

        reservationProposal.setDate(date);
        reservationProposal.setTime(time);
        reservationProposal.setNumberOfAdults(numberOfAdults);

        //When
        reservationProposal.checkValidity();

        //Then
        Assert.assertTrue(reservationProposal.isValidProposal());
    }
}