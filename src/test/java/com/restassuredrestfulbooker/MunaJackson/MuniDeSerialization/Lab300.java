package com.restassuredrestfulbooker.MunaJackson.MuniDeSerialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassuredrestfulbooker.MunaJackson.MunaBookingClass;
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
        MunaBookingClass booking = objectMapper.readValue(Payload, MunaBookingClass.class);
        System.out.println("This is that conversion : "+booking);
        System.out.println(booking.getFirstname());
        System.out.println(booking.getLastname());
    }
}
