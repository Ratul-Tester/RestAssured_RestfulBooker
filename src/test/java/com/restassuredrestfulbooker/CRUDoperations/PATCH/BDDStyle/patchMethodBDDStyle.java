package com.restassuredrestfulbooker.CRUDoperations.PATCH.BDDStyle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class patchMethodBDDStyle {

    String bookingid = "481";
    String token = "18e4f985a0d487a";
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
