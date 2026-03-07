package com.restassuredrestfulbooker.MunaJackson.MuniDeSerialization;

public class Lab300 {

    public void JsonStringToObject(){

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



    }
}
