package com.restassuredrestfulbooker.CRUDoperations.A.FunctionalTesting.PUT.NonBDDStyle;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class putMethodNonBDDStyle {
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_path = "/booking";
    String bookingid = "1129";
    String Valid_PAYLOAD="{\n" +
            "    \"firstname\" : \"Ramaaty\",\n" +
            "    \"lastname\" : \"Natiyal\",\n" +
            "    \"totalprice\" : 123,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    String Invalid_PAYLOAD="{\n" +
            "    \"firstname\" : 12,\n" +
            "    \"lastname\" : \"Natiyal\",\n" +
            "    \"totalprice\" : 123,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    String token = "432bcb499464e7f";

    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @Description("PUT Method in NonBDD Style for Fully Updating a booking with Valid Payload Positive TC")
    @Test
    public void putMethodPositiveTCNonBDDStyle(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_path+"/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(Valid_PAYLOAD);

        r = rs.when().log().all().put();

        vr = r.then().log().all().statusCode(200);
    }

    @Description("PUT Method in NonBDD Style for Fully Updating a booking with Invalid Payload Negative TC")
    @Test
    public void putMethodNegativeTCNonBDDStyle(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_path+"/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(Invalid_PAYLOAD);

        r = rs.when().log().all().put();

        vr = r.then().log().all().statusCode(500);
    }
}
