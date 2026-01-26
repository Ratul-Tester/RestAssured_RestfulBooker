package com.restassuredrestfulbooker.CRUDoperations.B.IntegrationTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class integrationTC2_createPartiallyUpdateDeleteNonBDDStyle {
    String token;
    Integer bookingid;
    String Payload = "{\n" +
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
    String Auth_Payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    String Partial_Payload = "{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\"\n" +
            "}";
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    String Base_Path_AUTH = "/auth";

    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @BeforeTest
    public void getToken(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path_AUTH);
        rs.contentType(ContentType.JSON);
        rs.body(Auth_Payload);

        r = rs.when().post();

        vr = r.then().log().all().statusCode(200);

        //token = r.jsonPath().getString(token);
        token = r.then().log().all().extract().path("token");
        System.out.println("Token Stored as : "+token);
    }

    @BeforeTest
    public void getBookingId(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(Payload);

        r = rs.when().post();

        vr = r.then().log().all().statusCode(200);

        bookingid = r.then().log().all().extract().path("bookingid");
        System.out.println("BookingId Stored as : "+bookingid);
    }

    @Test(priority = 0)
    public void partiallyUpdateBooking(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(Partial_Payload);

        r = rs.when().patch();

        vr = r.then().log().all().statusCode(200);
        String responseFirstname = r.then().extract().path("firstname");
        Assert.assertEquals(responseFirstname,"James");
    }

    @Test(priority = 1)
    public void deleteBooking(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);

        r = rs.when().delete();

        vr = r.then().log().all().statusCode(201);

    }

}
