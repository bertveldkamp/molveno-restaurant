package com.capgemini.molveno.restaurant.Reservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean hotelGuest;
    private String roomNumber;
    private String name;
    private String email;
    private String telephoneNumber;

    public Guest(){}

    public Guest(String name, String telephoneNumber, String email){
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }


    public boolean isHotelGuest() {
        return hotelGuest;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setHotelGuest(boolean hotelGuest) {
        this.hotelGuest = hotelGuest;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public long getId() { return id; }
}



