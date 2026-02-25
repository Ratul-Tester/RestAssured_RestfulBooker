package com.restassuredrestfulbooker.Serialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab295 {
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @Test
    public void createPositiveBooking(){
        PojoBookingClass booking = new PojoBookingClass();
        booking.setFirstname("Radha");
        booking.setLastname("Madhab");
        booking.setTotalprice(121);
        booking.setDepositpaid(true);

        PojoBookingDatesClass bookingdates = new PojoBookingDatesClass();
        bookingdates.setCheckin("2025-01-12");
        bookingdates.setCheckout("2026-01-12");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking.toString());

        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(booking);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);
    }

    @Test
    public void createNegativeBooking(){
        PojoBookingClass booking = new PojoBookingClass();
        NegativeBookingDetails negativeBookingDetails = new NegativeBookingDetails();
        negativeBookingDetails.setFirstname(126);
        booking.setLastname("Madhab");
        negativeBookingDetails.setTotalprice("Bal");
        booking.setDepositpaid(true);

        PojoBookingDatesClass bookingdates = new PojoBookingDatesClass();
        bookingdates.setCheckin("2025-01-12");
        bookingdates.setCheckout("2026-01-12");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking.toString());

        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(booking);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(500);
    }

}
