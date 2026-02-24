package com.restassuredrestfulbooker.Serialization;

public class NegativeBookingDetails {

    Integer firstname;
    String lastname;
    String totalprice;
    Integer depositpaid;
    BookingDates bookingdates;
    Integer additionalneeds;

    public Integer getFirstname() {
        return firstname;
    }

    public void setFirstname(Integer firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Integer depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public Integer getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(Integer additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
