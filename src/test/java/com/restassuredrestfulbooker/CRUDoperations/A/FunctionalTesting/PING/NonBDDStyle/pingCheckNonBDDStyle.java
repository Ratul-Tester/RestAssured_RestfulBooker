package com.restassuredrestfulbooker.CRUDoperations.A.FunctionalTesting.PING.NonBDDStyle;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class pingCheckNonBDDStyle {
    String Base_URL = "https://restful-booker.herokuapp.com";
    String Base_PATH = "/ping";
    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @Test
    public void pingCheckGETMethod(){
        rs.baseUri(Base_URL);
        rs.basePath(Base_PATH);
        rs.log().all();

        r = rs.when().log().all().get();

        vr = r.then().log().all().statusCode(201);
    }
}
