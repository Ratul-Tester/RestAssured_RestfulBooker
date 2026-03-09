package com.restassuredrestfulbooker.Jackson.Deserialization;

import com.restassuredrestfulbooker.Jackson.Booking;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class Lab300 {

    @Test
    public void JsonStringToObject() throws JsonProcessingException {
        String Payload = "{\n" +
                "    \"firstname\" : \"Raty\",\n" +
                "    \"lastname\" : \"Natiyal\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Booking booking = objectMapper.readValue(Payload, Booking.class);
        System.out.println(booking);
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());

    }
}
