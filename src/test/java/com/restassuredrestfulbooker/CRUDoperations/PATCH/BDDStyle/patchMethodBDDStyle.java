package com.restassuredrestfulbooker.CRUDoperations.PATCH.BDDStyle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class patchMethodBDDStyle {

    String bookingid = "2472";
    String token = "1d3863a312c9d9b";
    String Valid_Payload = "{\n" +
            "    \"firstname\" : \"Lala\",\n" +
            "    \"lastname\" : \"Na\"\n" +
            "}";

    @Test
    public void patchMethodPositiveTC(){
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking"+"/"+bookingid)
                .contentType(ContentType.JSON)
                .cookie("token",token)
                .body(Valid_Payload)

                .when().log().all().patch()

                .then().log().all().statusCode(200);
    }
}
