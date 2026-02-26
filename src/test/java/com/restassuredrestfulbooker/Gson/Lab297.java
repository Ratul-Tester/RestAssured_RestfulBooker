package com.restassuredrestfulbooker.Gson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab297 {
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    String Payload;

    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;
    @Test
    public void createBooking(){
        Booking booking = new Booking();
        booking.setFirstname("Ram");
        booking.setLastname("Chandra");
        booking.setTotalprice(121);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2020-01-12");
        bookingdates.setCheckout("2021-01-12");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        Gson gson = new Gson();
        String jsonString = gson.toJson(booking);
        //System.out.println(jsonString);

        System.out.println("THIS IS THAT : "+jsonString);

        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(jsonString);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

    }
}
