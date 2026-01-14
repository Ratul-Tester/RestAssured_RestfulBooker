package com.restassuredrestfulbooker.CRUDoperations.POST.BDDStyle;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class postMethodBDDStyle {

    String BASE_URL="https://restful-booker.herokuapp.com";
    String BASE_PATH="/booking";
    String Valid_PAYLOAD="{\n" +
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

    @Description("POST Method in BDD Style for creating valid booking id")
    @Test
    public void createBookingIdMethodPostPositiveTC(){
        RestAssured
                .given()
                .baseUri(BASE_URL)
                .basePath(BASE_PATH)
                .contentType(ContentType.JSON)
                .body(Valid_PAYLOAD)
                .log().all()

                .when().log().all().post()

                .then().log().all().statusCode(200);
    }

    @Description("POST Method in BDD Style for creating booking id with invalid firstname")
    @Test
    public void createBookingIdMethodPostNegativeTC(){
        RestAssured
                .given()
                .baseUri(BASE_URL)
                .basePath(BASE_PATH)
                .contentType(ContentType.JSON)
                .body(Invalid_PAYLOAD)
                .log().all()

                .when().log().all().post()

                .then().log().all().statusCode(500);
    }
}
