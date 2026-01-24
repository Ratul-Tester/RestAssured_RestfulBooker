package com.restassuredrestfulbooker.CRUDoperations.A.FunctionalTesting.PING.BDDStyle;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class pingCheckBDDStyle {

    String Base_URL = "https://restful-booker.herokuapp.com";
    String Base_PATH = "/ping";

    @Test
    public void pingCheckGETMethod(){
        RestAssured
                .given()
                .baseUri(Base_URL)
                .basePath(Base_PATH)
                .log().all()

                .when().log().all().get()

                .then().log().all().statusCode(201);
    }

}
