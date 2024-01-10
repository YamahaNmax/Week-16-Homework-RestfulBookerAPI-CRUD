package com.herokuapp.model;


import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class BookingPojo {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public static BookingPojo getRequestBody(String firstname, String lastname, Integer totalprice, Boolean depositpaid,
                                             Bookingdates bookingDates, String additionalneeds) {
        BookingPojo bookingPojo = new BookingPojo();
        if (firstname != null) {
            bookingPojo.setFirstname(firstname);
        }
        if (lastname != null) {
            bookingPojo.setLastname(lastname);
        }
        if (totalprice != null) {
            bookingPojo.setTotalprice(totalprice);
        }
        if (depositpaid != null) {
            bookingPojo.setDepositpaid(depositpaid);
        }
        if (bookingDates != null) {
            bookingPojo.setBookingdates(bookingDates);
        }
        if (additionalneeds != null) {
            bookingPojo.setAdditionalneeds(additionalneeds);
        }
        return bookingPojo;
    }

    public static BookingPojo getPatchRequestBody(String firstname, String lastname) {
        BookingPojo bookingPojo = new BookingPojo();
        if (firstname != null) {
            bookingPojo.setFirstname(firstname);
        }
        if (lastname != null) {
            bookingPojo.setLastname(lastname);
        }
        return bookingPojo;
    }

}