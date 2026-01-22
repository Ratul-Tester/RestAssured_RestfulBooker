package com.restassuredrestfulbooker.CRUDoperations.PATCH.NonBDDStyle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class patchMethodNonBDDStyle {
    String Base_URL = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    String bookingid = "2992";
    String token = "2ccc4935f935690";
    String Valid_Payload = "{\n" +
            "    \"firstname\" : \"Bala\",\n" +
            "    \"lastname\" : \"Na\"\n" +
            "}";
    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @Test
    public void patchMethodNonBDDStylePositiveTC(){

        rs.baseUri(Base_URL);
        rs.basePath(Base_Path+"/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(Valid_Payload);

        r = rs.log().all().when().patch();
        String response = r.asString();
        System.out.println(response);

        vr = r.then().log().all().statusCode(200);

    }
}
