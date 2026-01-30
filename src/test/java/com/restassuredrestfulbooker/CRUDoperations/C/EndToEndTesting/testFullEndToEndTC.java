package com.restassuredrestfulbooker.CRUDoperations.C.EndToEndTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class testFullEndToEndTC {
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    String Base_Path_Auth = "/auth";
    String Auth_Payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    String Booking_Payload = "{\n" +
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
    String Full_Update_Payload = "{\n" +
            "    \"firstname\" : \"King\",\n" +
            "    \"lastname\" : \"Crown\",\n" +
            "    \"totalprice\" : 777,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2019-01-01\",\n" +
            "        \"checkout\" : \"2020-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    String Partial_Update_Payload = "{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\"\n" +
            "}";
    String token;
    String bookingid;

    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @Test
    public void testAuthToGetToken(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path_Auth);
        rs.contentType(ContentType.JSON);
        rs.body(Auth_Payload);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

        token = r.then().extract().path("token");
    }
}
