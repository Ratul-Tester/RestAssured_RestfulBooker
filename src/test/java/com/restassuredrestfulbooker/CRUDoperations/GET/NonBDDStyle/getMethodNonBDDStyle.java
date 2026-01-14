package com.restassuredrestfulbooker.CRUDoperations.GET.NonBDDStyle;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class getMethodNonBDDStyle {

    String BASE_URL="https://restful-booker.herokuapp.com";
    String Valid_BASE_PATH="/booking/1702";
    String Invalid_BASE_PATH="/booking/-1";
    @Description("GET Method in Non-BDD Style for retrieving Valid booking id")
    @Test
    public void getMethodPositiveTC(){
        RequestSpecification rs = RestAssured.given();
        rs.baseUri(BASE_URL);
        rs.basePath(Valid_BASE_PATH).log().all();
        rs.when().log().all().get();
        rs.then().log().all().statusCode(200);


    }
    @Description("GET Method in Non-BDD Style for retrieving Invalid booking id")
    @Test
    public void getMethodNegativeTC(){
        RequestSpecification rs = RestAssured.given();
        rs.baseUri(BASE_URL);
        rs.basePath(Invalid_BASE_PATH).log().all();
        rs.when().log().all().get();
        rs.then().log().all().statusCode(404);


    }
}
