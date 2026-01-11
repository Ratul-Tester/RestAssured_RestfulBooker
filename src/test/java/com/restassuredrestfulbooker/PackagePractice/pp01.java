package com.restassuredrestfulbooker.PackagePractice;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class pp01 {
    @Description("TC 1 getRequest")
    @Test
    public void getRequest(){
        System.out.println("Request 1");
    }

    @Description("TC 2 Ping Test of Restful Booker")
    @Test
    public void getRequest01(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")

                .when().get()

                .then().statusCode(201);
    }
}
