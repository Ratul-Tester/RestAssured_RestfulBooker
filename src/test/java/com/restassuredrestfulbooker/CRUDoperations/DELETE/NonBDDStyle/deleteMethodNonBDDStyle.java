package com.restassuredrestfulbooker.CRUDoperations.DELETE.NonBDDStyle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class deleteMethodNonBDDStyle {

    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    String bookingid = "1737";
    String token = "4bc564afb65e3b7";
    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @Test(priority = 0)
    public void deleteMethodNonBDDStylePositiveTC(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.log().all();

        r = rs.when().log().all().delete();

        vr = r.then().log().all().statusCode(201);
    }

    @Test(priority = 1)
    public void checkDeleteBookingGETMethodPositiveTC(){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);
        rs.log().all();

        r = rs.when().log().all().get();

        vr = r.then().log().all().statusCode(404);
    }

}
