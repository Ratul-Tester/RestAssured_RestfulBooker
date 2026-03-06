package com.restassuredrestfulbooker.Deserialization;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.restassuredrestfulbooker.Gson.Booking;


public class BookingId {

    @SerializedName("bookingid")
    @Expose
    private Integer bookingid;
    @SerializedName("booking")
    @Expose
    private com.restassuredrestfulbooker.Gson.Booking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public com.restassuredrestfulbooker.Gson.Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}