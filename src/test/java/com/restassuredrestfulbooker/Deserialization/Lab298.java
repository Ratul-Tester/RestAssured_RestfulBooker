package com.restassuredrestfulbooker.Deserialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab298 {

    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";

    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @Test
    public void getObject(){

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

        Gson gson = new Gson();
        Booking booking = gson.fromJson(Payload, Booking.class);
        System.out.println(booking.toString());
        System.out.println(booking.getFirstname());

        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(booking);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

        Integer res = r.path("bookingid");

        System.out.println("This is the bookingid : "+res.toString());


    }
}
