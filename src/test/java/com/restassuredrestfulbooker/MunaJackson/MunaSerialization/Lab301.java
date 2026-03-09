package com.restassuredrestfulbooker.MunaJackson.MunaSerialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassuredrestfulbooker.MunaJackson.MunaBookingClass;
import com.restassuredrestfulbooker.MunaJackson.MuniBookingDatesClass;
import org.testng.annotations.Test;

public class Lab301 {

    @Test
    public void Object2JsonString() throws JsonProcessingException {
        MunaBookingClass munaBooking = new MunaBookingClass();
        munaBooking.setFirstname("Radha");
        munaBooking.setLastname("Madhav");
        munaBooking.setTotalprice(121);
        munaBooking.setDepositpaid(true);

        MuniBookingDatesClass muniBookingDates = new MuniBookingDatesClass();
        muniBookingDates.setCheckin("2018-01-12");
        muniBookingDates.setCheckout("2019-01-12");

        munaBooking.setBookingdates(muniBookingDates);
        munaBooking.setAdditionalneeds("Breakfast");

        System.out.println("The Object String is : "+munaBooking.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(munaBooking);

        System.out.println("This is that "+jsonString);
    }
}
