package com.restassuredrestfulbooker.CRUDoperations.POST.NonBDDStyle;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class postMethodNonBDDStyle {
    String BASE_URL="https://restful-booker.herokuapp.com";
    String BASE_PATH="/booking";
    String Valid_PAYLOAD="{\n" +
            "    \"firstname\" : \"Ratuy\",\n" +
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
    @Description("POST Method in Non-BDD Style for creating booking id with valid Payload")
    @Test
    public void postMethodPositiveTC(){
        RequestSpecification rs = RestAssured.given();
        rs.baseUri(BASE_URL);
        rs.basePath(BASE_PATH);
        rs.contentType(ContentType.JSON).log().all();
        rs.body(Valid_PAYLOAD);

        Response response = rs.when().log().all().post();
        String respoString = response.asString();
        System.out.println(respoString);

        ValidatableResponse vr = response.then();
        vr.log().all().statusCode(200);


    }
    @Description("POST Method in Non-BDD Style for creating booking id with Invalid Payload")
    @Test
    public void postMethodNegativeTC(){
        RequestSpecification rss = RestAssured.given();
        rss.baseUri(BASE_URL);
        rss.basePath(BASE_PATH);
        rss.contentType(ContentType.JSON).log().all();
        rss.body(Invalid_PAYLOAD);

        Response r = rss.when().log().all().post();
        String respoString = r.asString();
        System.out.println(respoString);

        ValidatableResponse vr = r.then();
        vr.log().all().statusCode(500);
    }
}
