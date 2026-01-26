package com.restassuredrestfulbooker.CRUDoperations.B.IntegrationTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class integrationTC3_CreateUpdateDeleteCheck {
    Integer bookingid;
    String token;
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
    String Payload_Auth = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    String Payload_Update = "{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    String Base_Path_Auth = "/auth";

    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @BeforeTest
    public void generateToken(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path_Auth);
        rs.contentType(ContentType.JSON);
        rs.body(Payload_Auth);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

        token = r.then().extract().path("token");
        System.out.println("Token is : "+token);
        Assert.assertNotNull(token);
    }

    @BeforeTest
    public void generateBookingId(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(Payload);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

        bookingid = r.then().extract().path("bookingid");
        System.out.println("Booking Id is : "+bookingid);
        Assert.assertNotNull(bookingid);
    }

    @Test(priority = 1)
    public void updateBooking(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(Payload_Update);

        r = rs.when().log().all().put();

        vr = r.then().log().all().statusCode(200);
        String responseFirstName = r.then().extract().path("firstname");
        Assert.assertEquals(responseFirstName,"James");
    }


    @Test(priority = 2)
    public void deleteBooking(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);

        r = rs.when().log().all().delete();

        vr = r.then().log().all().statusCode(201);

    }

}
