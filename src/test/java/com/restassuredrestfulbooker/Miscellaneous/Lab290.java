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

public class Lab290 {

    @Test
    public void testDatas(){
        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        jsonBodyUsingMap.put("firstname", firstName);
        jsonBodyUsingMap.put("lastname", lastName);
        jsonBodyUsingMap.put("totalprice", faker.number().randomDigit());
        jsonBodyUsingMap.put("depositpaid", faker.random().nextBoolean());

        Map<String, Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin", "2019-01-01");
        bookingDatesMap.put("checkout", "2020-01-01");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast and Lunch");

        System.out.println(jsonBodyUsingMap);

        String body = jsonBodyUsingMap.toString();

        RequestSpecification rs = RestAssured.given();
        Response response;
        ValidatableResponse validatableResponse;

        String Base_Url = "https://restful-booker.herokuapp.com";
        String Base_Path = "/booking";

        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(body);

        response = rs.when().log().all().post();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }
}
