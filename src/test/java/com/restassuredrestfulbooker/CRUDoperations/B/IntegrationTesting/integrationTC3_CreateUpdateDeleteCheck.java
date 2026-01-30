package com.restassuredrestfulbooker.CRUDoperations.B.IntegrationTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class integrationTC3_CreateUpdateDeleteCheck {
    Integer bookingid;
    String token;
    String Payload = "{\n" +
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
    String Payload_Auth = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    String Payload_Update = "{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Smith\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    String Base_Path_Auth = "/auth";

    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @BeforeTest
    public void generateToken() {
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path_Auth);
        rs.contentType(ContentType.JSON);
        rs.body(Payload_Auth);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

        token = r.then().extract().path("token");
        System.out.println("Token is : " + token);
        Assert.assertNotNull(token);
    }

    @BeforeTest
    public void generateBookingId() {
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(Payload);
        rs.log().all();

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

        bookingid = r.then().extract().path("bookingid");
        System.out.println("Booking Id is : " + bookingid);
        Assert.assertNotNull(bookingid);

        String responseFirstName = r.then().extract().path("booking.firstname");
        System.out.println("FIRST NAME ::" + responseFirstName);
        Assert.assertEquals(responseFirstName,"Jim");

        String responselastname = r.then().extract().path("booking.lastname");
        Assert.assertEquals(responselastname,"Brown");

        Integer responsetotalprice = r.then().extract().path("booking.totalprice");
        Assert.assertEquals(responsetotalprice,111);

        Boolean responsedepositpaid = r.then().extract().path("booking.depositpaid");
        Assert.assertEquals(responsedepositpaid,true);

        Object responsebookingdates = r.then().extract().path("booking.bookingdates.checkin");
        System.out.println("RESPONSE BOOKING DATES :::: "+responsebookingdates);
        Assert.assertEquals(responsebookingdates,"2018-01-01");

        String responseadditioonalneeds = r.then().extract().path("booking.additionalneeds");
        Assert.assertEquals(responseadditioonalneeds,"Breakfast");
    }

    @Test(priority = 1)
    public void updateBooking() {
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path + "/" + bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", token);
        rs.body(Payload_Update);

        r = rs.when().log().all().put();

        vr = r.then().log().all().statusCode(200);
        String responseFirstName = r.then().extract().path("firstname");
        Assert.assertEquals(responseFirstName, "James");

        String fullResponse = r.asString();

        JsonPath jsonPath = new JsonPath(fullResponse);
        String extractedFirstName = jsonPath.getString("firstname");
        String extractedLastName = jsonPath.getString("lastname");
        Integer extractedTotalPrice = jsonPath.getInt("totalprice");
        String extractedCheckinDate = jsonPath.getString("bookingdates.checkin");
        String extractedCheckoutDate = jsonPath.getString("bookingdates.checkout");
        String extractedAdditionalNeeds = jsonPath.getString("additionalneeds");

        System.out.println("First Name is :: "+extractedFirstName);
        System.out.println("Last Name is :: "+extractedLastName);
        System.out.println("Total Price is :: "+extractedTotalPrice);
        System.out.println("Checkin Date is :: "+extractedCheckinDate);
        System.out.println("Checkout Date is :: "+extractedCheckoutDate);
        System.out.println("Additional Needs is :: "+extractedAdditionalNeeds);

        Assert.assertEquals(extractedFirstName,"James");
        Assert.assertEquals(extractedLastName,"Smith");
        Assert.assertEquals(extractedTotalPrice,111);
        Assert.assertEquals(extractedCheckinDate,"2018-01-01");
        Assert.assertEquals(extractedCheckoutDate,"2019-01-01");
        Assert.assertEquals(extractedAdditionalNeeds,"Breakfast");

        assertThat(extractedFirstName)
                .isEqualTo("James").isNotBlank();
        assertThat(extractedLastName)
                .isEqualTo("Smith").isNotEmpty().isNotBlank();
        assertThat(extractedTotalPrice)
                .isEqualTo(111).isNotNegative().isNotZero();
        assertThat(extractedCheckinDate).isNotEmpty();
        assertThat(extractedCheckoutDate).isNotBlank();
        assertThat(extractedAdditionalNeeds).isNotBlank();
    }


    @Test(priority = 2)
    public void deleteBooking() {
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path + "/" + bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", token);

        r = rs.when().log().all().delete();

        vr = r.then().log().all().statusCode(201);
    }

}
