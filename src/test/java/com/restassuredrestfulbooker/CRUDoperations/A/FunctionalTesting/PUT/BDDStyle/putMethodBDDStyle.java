package com.restassuredrestfulbooker.CRUDoperations.A.FunctionalTesting.PUT.BDDStyle;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class putMethodBDDStyle {

    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_path = "/booking";
    String bookingid = "1206";
    String Valid_PAYLOAD="{\n" +
            "    \"firstname\" : \"Raaaaty\",\n" +
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
    String token = "f60e81968147ea1";

    @Description("PUT Method in BDD Style for Fully Updating a booking with Valid Payload Positive TC")
    @Test
    public void updateBookingPutMethodPositiveTC(){
        RestAssured
                .given()
                .baseUri(Base_Url)
                .basePath(Base_path+"/"+bookingid)
                .contentType(ContentType.JSON)
                .cookie("token",token)
                .body(Valid_PAYLOAD)

                .when().log().all().put()

                .then().log().all().statusCode(200);
    }

    @Description("PUT Method in BDD Style for Fully Updating a booking with Invalid Payload Negative TC")
    @Test
    public void updateBookingPutMethodNegativeTC(){
        RestAssured
                .given()
                .baseUri(Base_Url)
                .basePath(Base_path+"/"+bookingid)
                .contentType(ContentType.JSON)
                .cookie("token",token)
                .body(Invalid_PAYLOAD)

                .when().log().all().put()

                .then().log().all().statusCode(500);
    }

}
