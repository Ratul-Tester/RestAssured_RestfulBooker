package com.restassuredrestfulbooker.CRUDoperations.A.FunctionalTesting.GET.BDDStyle;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class getMethodBDDStyle {

    @Description("GET Method in BDD Style for retrieving all booking id's")
    @Test
    public void getMethod(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking"+"/"+"1206").log().all()

                .when().log().all().get()

                .then().log().all().statusCode(200);
    }
}
