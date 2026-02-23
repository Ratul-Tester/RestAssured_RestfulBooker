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

public class Lab291 {

    @Test
    public void testMapping(){
        Map<String,Object> jsonBody = new LinkedHashMap<>();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        jsonBody.put("firstname", firstName);
        jsonBody.put("lastname", lastName);
        jsonBody.put("totalprice", faker.random().nextInt(1000));
        jsonBody.put("depositepaid", faker.random().nextBoolean());

        Map<String, Object> bookingDates = new LinkedHashMap<>();
        bookingDates.put("checkin", "2019-01-01");
        bookingDates.put("checkout", "2020-01-01");

        jsonBody.put("bookingdates", bookingDates);
        jsonBody.put("additionalneeds", "breakfast");

        System.out.println(jsonBody);

        String bala = jsonBody.toString();

        String Base_Url = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        RequestSpecification rs = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;

        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(bala);

        response = rs.when().log().all().post();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }
}
