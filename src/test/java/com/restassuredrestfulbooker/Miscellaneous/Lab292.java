package com.restassuredrestfulbooker.Miscellaneous;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lab292 {

    @Test
    public void testCreatePayload(){

        String Base_Url = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        Map<String, Object> jsonMapped = new LinkedHashMap<>();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        Integer totalPrice = faker.random().nextInt(1,1000);
        Boolean depositePaid = faker.random().nextBoolean();

        Map<String, Object> bookingDatesMapped = new LinkedHashMap<>();
        bookingDatesMapped.put("checkin","2019-01-01");
        bookingDatesMapped.put("checkout","2020-01-01");

        String additionalNeeds = faker.food().dish();

        jsonMapped.put("firstname", firstName);
        jsonMapped.put("lastname", lastName);
        jsonMapped.put("totalprice", totalPrice);
        jsonMapped.put("depositepaid", depositePaid);
        jsonMapped.put("bookingdates", bookingDatesMapped);
        jsonMapped.put("additionalneeds", additionalNeeds);

        String body = jsonMapped.toString();

        RequestSpecification rs = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;

        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(body);

        response = rs.when().log().all().post();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }
}
