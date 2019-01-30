package com.capgemini.molveno.restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservationProposal {

    private LocalDate date;
    private LocalTime beginTime;
    private LocalTime endTime;
    private int numberOfAdults;
    private int numberOfChildren;
    private boolean validProposal = false;

    public boolean checkValidity(){
        if(numberOfAdults < 1 || beginTime.atDate(date).isBefore(LocalDateTime.now())){
            System.out.println("Date is in the past");
            this.validProposal = false;
        } else {
            this.validProposal = true;
        }
        return validProposal;
    }

    public void setDate(LocalDate date) { this.date = date; }

    public void setBeginTime(LocalTime beginTime) { this.beginTime = beginTime; this.endTime = beginTime.plusHours(2); }

    public void setNumberOfAdults(int numberOfAdults) { this.numberOfAdults = numberOfAdults; }

    public boolean isValidProposal() {
        return validProposal;
    }

    public LocalDateTime getBeginTime() {
        return beginTime.atDate(date);
    }

    public LocalDateTime getEndTime() {
        return endTime.atDate(date);
    }

    public int getNumberOfPeople() { return numberOfAdults + numberOfChildren; }
}
