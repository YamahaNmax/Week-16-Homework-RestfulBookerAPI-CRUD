package com.herokuapp.model;


import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Bookingdates {

    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public static Bookingdates getBookingDates(String checkIn, String checkout) {
        Bookingdates bookingDates = new Bookingdates();
        if (checkIn != null) {
            bookingDates.setCheckin(checkIn);
        }
        if (checkout != null) {
            bookingDates.setCheckout(checkout);
        }
        return bookingDates;
    }

}