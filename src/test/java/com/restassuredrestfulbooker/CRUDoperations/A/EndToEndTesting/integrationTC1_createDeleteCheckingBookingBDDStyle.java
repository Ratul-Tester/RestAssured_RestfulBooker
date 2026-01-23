package com.restassuredrestfulbooker.CRUDoperations.A.EndToEndTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class integrationTC1_createDeleteCheckingBookingBDDStyle {
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path_Auth = "/auth";
    String AuthPayload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    String Base_Path_Booking = "/booking";
    String BookingPayload = "{\n" +
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

    String bookingid;
    Response response;
    ValidatableResponse vr;
    String token;

    @Test(priority = 1)
    public void generatingAuth() {
        response = RestAssured.given()
                .baseUri(Base_Url)
                .basePath(Base_Path_Auth)
                .contentType(ContentType.JSON)
                .body(AuthPayload).log().all()

                .when().log().all().post();

        vr = response.then().log().all().statusCode(200);

        token = response.jsonPath().getString("token");
        //System.out.println("token:" + token);
    }

    @Test(priority = 2)
    public void createBookingIdMethodPostPositiveTC() {
        response = RestAssured
                .given()
                .baseUri(Base_Url)
                .basePath(Base_Path_Booking)
                .contentType(ContentType.JSON)
                .log().all()
                .body(BookingPayload)

                .when().log().all().post();

        vr = response.then().log().all().statusCode(200);

        bookingid = response.jsonPath().getString("bookingid");
        //System.out.println("bookingid:" + bookingid);
    }

    @Test(priority = 3)
    public void deleteMethodBDDStylePositiveTC() {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking" + "/" + bookingid)
                .contentType(ContentType.JSON)
                .cookie("token", token)

                .when().log().all().delete()

                .then().log().all().statusCode(201);
    }

    @Test(priority = 4)
    public void checkDeletedBookingGETMethodBDDStylePositiveTC() {
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking" + "/" + bookingid)
                .contentType(ContentType.JSON)

                .when().log().all().get()

                .then().log().all().statusCode(404);
    }

}
