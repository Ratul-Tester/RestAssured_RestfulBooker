package com.restassuredrestfulbooker.Serialization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab293 {

    String BASE_URL="https://restful-booker.herokuapp.com";
    String BASE_PATH="/booking";

    @Description("POST Method in Non-BDD Style for creating booking id with valid Payload")
    @Test(priority = 0)
    public void postMethodPositiveTC(){

        Booking booking = new Booking();
        booking.setFirstname("Radha");
        booking.setLastname("Shyama");
        booking.setTotalprice(121);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2018-01-12");
        bookingdates.setCheckout("2019-01-12");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");

        System.out.println(booking.toString());

        RequestSpecification rs = RestAssured.given();
        rs.baseUri(BASE_URL);
        rs.basePath(BASE_PATH);
        rs.contentType(ContentType.JSON).log().all();
        rs.body(booking);

        Response response = rs.when().log().all().post();
        String respoString = response.asString();
        System.out.println(respoString);

        ValidatableResponse vr = response.then();
        vr.log().all().statusCode(200);


    }
    @Description("POST Method in Non-BDD Style for creating booking id with Invalid Payload")
    @Test(priority = 1)
    public void postMethodNegativeTC(){

        Booking booking = new Booking();
        booking.setFirstname("g");
        booking.setLastname("Shyama");
        booking.setTotalprice(121);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2019-01-12");
        bookingdates.setCheckout("2020-01-12");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Lunch");

        System.out.println(booking.toString());

        RequestSpecification rs = RestAssured.given();
        rs.baseUri(BASE_URL);
        rs.basePath(BASE_PATH);
        rs.contentType(ContentType.JSON).log().all();
        rs.body(booking);

        Response response = rs.when().log().all().post();
        String respoString = response.asString();
        System.out.println(respoString);

        ValidatableResponse vr = response.then();
        vr.log().all().statusCode(200);

    }
}
