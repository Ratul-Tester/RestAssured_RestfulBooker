package com.restassuredrestfulbooker.Serialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Lab296 {

    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";

    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    //String Payload1;

    @Test
    public void createMultipleBookingID(){

        PojoBookingClass booking = new PojoBookingClass();
        booking.setFirstname("Sambhu");
        booking.setLastname("Shankar");
        booking.setTotalprice(8400);
        booking.setDepositpaid(true);

        PojoBookingDatesClass bookingDates = new PojoBookingDatesClass();
        bookingDates.setCheckin("2018-01-12");
        bookingDates.setCheckout("2019-01-12");

        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        PojoBookingClass booking1 = new PojoBookingClass();
        booking1.setFirstname("Girija");
        booking1.setLastname("Shankar");
        booking1.setTotalprice(108);
        booking1.setDepositpaid(true);

        PojoBookingDatesClass bookingDates1 = new PojoBookingDatesClass();
        bookingDates1.setCheckin("2019-01-12");
        bookingDates1.setCheckout("2020-01-12");

        booking.setBookingdates(bookingDates1);
        booking.setAdditionalneeds("Breakfast & Lunch");

        ArrayList Payload = new ArrayList();
        Payload.add(booking);
        Payload.add(booking1);

        //Payload1 = Payload.toString();

        System.out.println(Payload);

        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(Payload);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

    }
}
