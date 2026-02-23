package com.restassuredrestfulbooker.Miscellaneous;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class testEndToEnd {
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    String Auth_Base_Path = "/auth";
    String Auth_Payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    String token;
    String CreateBooking_Payload = "{\n" +
            "    \"firstname\" : \"Jim\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    Integer bookingid;
    String UpdateBooking_Payload = "{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Nandy\",\n" +
            "    \"totalprice\" : 143,\n" +
            "    \"depositpaid\" : false,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2019-01-01\",\n" +
            "        \"checkout\" : \"2020-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast and Lunch\"\n" +
            "}";
    String PartialBooking_Payload = "{\n" +
            "    \"firstname\" : \"Ratul\",\n" +
            "    \"lastname\" : \"Nandy\"\n" +
            "}";

    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @Test(priority = 1)
    public void testCreateToken() {
        rs.baseUri(Base_Url);
        rs.basePath(Auth_Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(Auth_Payload);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

        token = r.then().extract().path("token");

        System.out.println("Extracted Token is :: " + token);

        String authResponse = r.asString();

        JsonPath jsonPath = new JsonPath(authResponse);
        token = jsonPath.getString("token");

        assertThat(token).isAlphanumeric().isNotNull();

        System.out.println("Assert Token is :: " + token);
    }

    @Test(priority = 2)
    public void testCreateBooking() {
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(CreateBooking_Payload);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

        bookingid = r.then().extract().path("bookingid");

        String bookingResponse = r.asString();

        JsonPath jsonPath = new JsonPath(bookingResponse);
        bookingid = jsonPath.getInt("bookingid");
        assertThat(bookingid).isNotNull().isNotNegative().isBetween(0, 9999);
        System.out.println("Booking ID is :: " + bookingid);
        String responseFirstName = jsonPath.getString("booking.firstname");
        System.out.println("First NAME is :: "+responseFirstName);
        assertThat(responseFirstName).isEqualToIgnoringCase("JiM");
    }
}
