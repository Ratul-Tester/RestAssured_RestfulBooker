package com.restassuredrestfulbooker.PackagePractice;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class pp02 {

    @Description("TC 01 of pp02 Step 1")
    @Test
    public void Step1(){
        System.out.println("This is Step1");
    }

    @Description("TC 2 of pp02 Step 2 Ping Test of Restful Booker")
    @Test
    public void Step2(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")

                .when().get()

                .then().statusCode(201);
    }
    @Description("TC 3 Ping Test of Restful Booker")
    @Test
    public void Step03(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")

                .when().get()

                .then().statusCode(201);
    }
}
