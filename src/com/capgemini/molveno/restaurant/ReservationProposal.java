package com.capgemini.molveno.restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservationProposal {

    private LocalDate date;
    private LocalTime time;
    private int numberOfAdults;
    private int numberOfChildren;
    private boolean validProposal = false;

    public boolean checkAvailable(LocalDate date, LocalTime time, int numberOfAdults, int numberOfChildren){
        this.date = date;
        this.time = time;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;

        checkValidity();

        if(validProposal){
            //code om te checken of er plek is
            return true;
        } else {
            return false;
        }
    }

    public void checkValidity(){
        if(numberOfAdults < 1 && time.atDate(date).isBefore(LocalDateTime.now())){
            System.out.println("Date is in the past");
            this.validProposal = false;
        } else {
            this.validProposal = true;
        }


    }


}
