package com.restassuredrestfulbooker.CRUDoperations.A.FunctionalTesting.DELETE.BDDStyle;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class deleteMethodBDDStyle {

    String bookingid = "581";
    String token = "4320e3a5e5a909c";

    @Test(priority = 0)
    public void deleteMethodBDDStylePositiveTC(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking"+"/"+bookingid)
                .contentType(ContentType.JSON)
                .cookie("token",token)

                .when().log().all().delete()

                .then().log().all().statusCode(201);
    }

    @Test(priority = 1)
    public void checkDeleteMethodBDDStylePostDeletion(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking"+"/"+bookingid)
                .contentType(ContentType.JSON)

                .when().log().all().get()

                .then().log().all().statusCode(404);
    }
}
