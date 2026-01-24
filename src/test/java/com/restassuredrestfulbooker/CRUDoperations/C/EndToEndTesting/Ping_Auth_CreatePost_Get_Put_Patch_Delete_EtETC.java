package com.restassuredrestfulbooker.CRUDoperations.C.EndToEndTesting;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Ping_Auth_CreatePost_Get_Put_Patch_Delete_EtETC {
    String Base_URL = "https://restful-booker.herokuapp.com";
    String Base_PATH = "/booking";
    String Base_path_Ping = "/ping";
    String Base_path_Auth = "/auth";
    String token;
    String bookingid;
    String Payload_Auth = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    String Payload_Booking = "{\n" +
            "    \"firstname\" : \"Jim\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    String Payload_UpdateBooking = "{\n" +
            "    \"firstname\" : \"Ratul\",\n" +
            "    \"lastname\" : \"Nandy\",\n" +
            "    \"totalprice\" : 143,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    String Payload_PatchBooking = "{\n" +
            "    \"firstname\" : \"Sunoyoni\",\n" +
            "    \"lastname\" : \"Nandy\"\n" +
            "}";

    RequestSpecification rs = RestAssured.given();
    Response response;
    ValidatableResponse validatableResponse;

    @Description("Performing Ping / Health Checkup")
    @Test(priority = 0)
    public void pingCheck(){
        RestAssured
                .given()
                .baseUri(Base_URL)
                .basePath(Base_path_Ping)
                .log().all()

                .when().get()

                .then().log().all().statusCode(201);
    }

    @Description("Token will be generated and stored in token variable")
    @Test(priority = 1)
    public void tokenGenerating(){
        rs.baseUri(Base_URL)
                .basePath(Base_path_Auth)
                .contentType(ContentType.JSON)
                .body(Payload_Auth)
                .log().all();

                response = rs.when().post();

                validatableResponse = response.then().log().all().statusCode(200);

                token = response.jsonPath().getString("token");
    }

    @Description("Booking Id will be created and stored in bookingid variable")
    @Test(priority = 2)
    public void createBooking(){
        rs.baseUri(Base_URL)
                .basePath(Base_PATH)
                .contentType(ContentType.JSON)
                .body(Payload_Booking)
                .log().all();

        response = rs.when().post();

        validatableResponse = response.then().log().all().statusCode(200);

        bookingid = response.jsonPath().getString("bookingid");
    }

    @Description("Checking the created booking with booking id")
    @Test(priority = 3)
    public void getBookingid(){

    }


}
