package com.restassuredrestfulbooker.CRUDoperations.AUTH.NonBDDStyle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class creatingAuthTokenNonBDDStyleMethodPOST {
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/auth";
    String AuthBody = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    String token;
    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @Test
    public void generating_Auth(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(AuthBody);
        rs.log().all();

        r = rs.when().post();

        vr = r.then().log().all().statusCode(200);

        token = r.jsonPath().getString("token");
        System.out.println("token:"+token);
    }
}
