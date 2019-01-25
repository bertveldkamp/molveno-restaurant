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

    public boolean checkValidity(){
        if(numberOfAdults < 1 || time.atDate(date).isBefore(LocalDateTime.now())){
            System.out.println("Date is in the past");
            this.validProposal = false;
        } else {
            this.validProposal = true;
        }
        return validProposal;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public void setNumberOfChildren(int numberOfChildren){
        this.numberOfChildren = numberOfChildren;
    }

    public boolean isValidProposal() {
        return validProposal;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }
}
