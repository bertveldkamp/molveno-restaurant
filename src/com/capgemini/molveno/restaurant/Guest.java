package com.capgemini.molveno.restaurant;

public class Guest {

    private boolean hotelGuest;
    private String roomNumber;
    private String name;
    private String email;
    private String telephoneNumber;

    public Guest() {

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


}



