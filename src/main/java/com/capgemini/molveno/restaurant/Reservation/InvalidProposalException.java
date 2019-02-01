package com.capgemini.molveno.restaurant.Reservation;

public class InvalidProposalException extends Exception{

    private final String exceptionMessage = "This proposal is invalid";

    public final String getExceptionMessage() {
        return exceptionMessage;
    }
}
