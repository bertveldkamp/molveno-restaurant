package com.capgemini.molveno.restaurant;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private LocalDate datum;
    private LocalTime tijd;
    private int nrOfPeople;
    private int nrOfChildren;
    private boolean groupComplete = false;
    private int reservationNumber;


    public Reservation(LocalDate datum, LocalTime tijd, int nrOfPeople , int nrOfChildren)
    {
        this.datum = datum;
        this.tijd = tijd;
        this.nrOfPeople = nrOfPeople;
        this.nrOfChildren = nrOfChildren;

        //resnr aanmaken
        int reserveringsnummer = 1234;

        //resernr vastleggen
        this.reservationNumber = reserveringsnummer;

    }
}
{
    Public
        }  =  LocalDateTime.now
    LocalDateTime.now =< LocalDateTime


Public static boolean NrofAdults is Numeric
Public static boolean NrofChildren is Numeric

constructor

Public static void NrofAdults{}{
    System.out.println('' please fill in the number of Adults'')

Public static void NrofChildren{}{}
        System.out.println('' please fill in the number of Children'')

Public Reservarion (int LocalDateTime, int LocalTime, int NrofAdults, int NrofChildren )
* // Check in database of tijdstip t/m + 2 uur beschikbaar is)





If(Reservation =){
System.out.println("Available")
}

Else
        {system.out.println("not available; try another option")
}
}


Void Available  {Would you like to confirm}