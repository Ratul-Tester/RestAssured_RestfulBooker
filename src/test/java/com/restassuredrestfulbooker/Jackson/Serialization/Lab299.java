package com.restassuredrestfulbooker.Jackson.Serialization;

import com.restassuredrestfulbooker.Jackson.Booking;
import com.restassuredrestfulbooker.Jackson.Bookingdates;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class Lab299 {

    @Test
    public void JacksonSerialization() throws JsonProcessingException {
        Booking booking = new Booking();
        booking.setFirstname("Shiv");
        booking.setLastname("Sambhu");
        booking.setTotalprice(121);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-12");
        bookingdates.setCheckout("2019-01-12");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println("This is that : "+booking);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);

        System.out.println("This is that new Json String : "+jsonString);
    }
}
