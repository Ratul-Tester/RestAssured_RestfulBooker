package com.restassuredrestfulbooker.CRUDoperations.A.FunctionalTesting.AUTH.BDDStyle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class creatingAuthTokenBDDStyleMethodPOST {
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/auth";
    String AuthBody = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    @Test
    public void creatingAuth(){
        RestAssured
                .given()
                .baseUri(Base_Url)
                .basePath(Base_Path)
                .contentType(ContentType.JSON)
                .body(AuthBody).log().all()

                .when().log().all().post()

                .then().log().all().statusCode(200);
    }
}
