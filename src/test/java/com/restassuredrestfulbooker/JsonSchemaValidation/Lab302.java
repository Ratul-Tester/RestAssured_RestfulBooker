package com.restassuredrestfulbooker.JsonSchemaValidation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

public class Lab302 {

    @Test
    public void JsonSchemaValidating(){

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .when().get()
                .then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/JsonSchema.json")));
    }
}
