package com.capgemini.molveno.restaurant.Reservation;

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
            this.validProposal = false;
        } else {
            this.validProposal = true;
        }
        return validProposal;
    }

    public void setDate(LocalDate date) { this.date = date; }

    public void setBeginTime(LocalTime beginTime) { this.beginTime = beginTime; this.endTime = beginTime.plusHours(2); }

    public void setNumberOfAdults(int numberOfAdults) { this.numberOfAdults = numberOfAdults; }

    public void setNumberOfChildren(int numberOfChildren) { this.numberOfChildren = numberOfChildren; }

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

    public int getNumberOfChildren() { return numberOfChildren; }
}
