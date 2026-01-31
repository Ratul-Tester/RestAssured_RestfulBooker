package com.restassuredrestfulbooker.CRUDoperations.C.EndToEndTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.testng.annotations.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


public class testFullEndToEndTC {
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_Path = "/booking";
    String Base_Path_Auth = "/auth";
    String Auth_Payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    String Booking_Payload = "{\n" +
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
    String Full_Update_Payload = "{\n" +
            "    \"firstname\" : \"King\",\n" +
            "    \"lastname\" : \"Crown\",\n" +
            "    \"totalprice\" : 777,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2019-01-01\",\n" +
            "        \"checkout\" : \"2020-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    String Partial_Update_Payload = "{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\"\n" +
            "}";
    String token;
    Integer bookingid;

    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;

    @Test(groups = {"Authentication"}, priority = 1)
    public void testAuthToGetToken (){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path_Auth);
        rs.contentType(ContentType.JSON);
        rs.body(Auth_Payload);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

        //token = r.then().extract().path("token");

        String authResponse = r.asString();
        JsonPath jsonPath = new JsonPath(authResponse);
        token = jsonPath.getString("token");

        assertThat(token).isNotNull().isAlphanumeric();
    }

    @Test(groups = {"BookingId"}, priority = 2)
    public void testBookingToGetBookingId (){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path);
        rs.contentType(ContentType.JSON);
        rs.body(Booking_Payload);

        r = rs.when().log().all().post();

        vr = r.then().log().all().statusCode(200);

        //bookingid = r.then().extract().path("bookingid");
        //System.out.println("BOOKING ID is :::: "+bookingid);

        String bookingIdResponse = r.asString();
        JsonPath jsonPath = new JsonPath(bookingIdResponse);
        bookingid = jsonPath.getInt("bookingid");

        assertThat(bookingid).isNotNull().isBetween(0,9999);
    }

    @Test
    public void testCreatedBooking (){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);

        r = rs.when().log().all().get();

        vr = r.then().log().all().statusCode(200);

        String tcbResponse = r.asString();
        JsonPath jsonPath = new JsonPath(tcbResponse);

        String tcbFirstName = jsonPath.getString("firstname");
        assertThat(tcbFirstName).containsIgnoringCase("jIM");

        String tcbLastName = jsonPath.getString("lastname");
        assertThat(tcbLastName).containsIgnoringCase("Brown");

        Integer tcbTotalPrice = jsonPath.getInt("totalprice");
        assertThat(tcbTotalPrice).isNotNull().isNotNegative().isNotZero();

        Boolean tcbDepositPaid = jsonPath.getBoolean("depositpaid");
        assertThat(tcbDepositPaid).isTrue();

        Object tcbbookingDates = jsonPath.getJsonObject("bookingdates");
        assertThat(tcbbookingDates).isNotNull();

        String tcbcheckin = jsonPath.getJsonObject("bookingdates.checkin");
        assertThat(tcbcheckin).isEqualTo("2018-01-01");

        String tcbcheckout = jsonPath.getJsonObject("bookingdates.checkout");
        assertThat(tcbcheckout).isEqualTo("2019-01-01");

        String tcbAdditionalNeeds = jsonPath.getString("additionalneeds");
        assertThat(tcbAdditionalNeeds).containsIgnoringCase("breakfast");
    }

    @Test(dependsOnGroups = {"Authentication","BookingId"})
    public void testPartialUpdate (){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(Partial_Update_Payload);

        r = rs.when().log().all().patch();

        vr = r.then().log().all().statusCode(200);

        String tpuResponse = r.asString();

        JsonPath jsonPath = new JsonPath(tpuResponse);

        String tpuFirstName = jsonPath.getString("firstname");
        assertThat(tpuFirstName).contains("James").isNotBlank().isNotNull();
        String tpuLastName = jsonPath.getString("lastname");
        assertThat(tpuLastName).contains("Brown").isNotNull().isNotBlank();
    }

    @Test
    public void testPartialUpdatedBooking (){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);

        r = rs.when().log().all().get();

        vr = r.then().log().all().statusCode(200);

        String tcbResponse = r.asString();
        JsonPath jsonPath = new JsonPath(tcbResponse);

        String tcbFirstName = jsonPath.getString("firstname");
        assertThat(tcbFirstName).containsIgnoringCase("jAmEs");

        String tcbLastName = jsonPath.getString("lastname");
        assertThat(tcbLastName).containsIgnoringCase("Brown");

        Integer tcbTotalPrice = jsonPath.getInt("totalprice");
        assertThat(tcbTotalPrice).isNotNull().isNotNegative().isNotZero();

        Boolean tcbDepositPaid = jsonPath.getBoolean("depositpaid");
        assertThat(tcbDepositPaid).isTrue();

        Object tcbbookingDates = jsonPath.getJsonObject("bookingdates");
        assertThat(tcbbookingDates).isNotNull();

        String tcbcheckin = jsonPath.getJsonObject("bookingdates.checkin");
        assertThat(tcbcheckin).isEqualTo("2018-01-01");

        String tcbcheckout = jsonPath.getJsonObject("bookingdates.checkout");
        assertThat(tcbcheckout).isEqualTo("2019-01-01");

        String tcbAdditionalNeeds = jsonPath.getString("additionalneeds");
        assertThat(tcbAdditionalNeeds).containsIgnoringCase("breakfast");
    }

    @Test(dependsOnGroups = {"Authentication.BookingId"}, dependsOnMethods = "testPartialUpdate")
    public void testFullUpdate (){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(Full_Update_Payload);

        r = rs.when().log().all().put();

        vr = r.then().log().all().statusCode(200);

        String tfuResponse = r.asString();

        JsonPath jsonPath = new JsonPath(tfuResponse);

        String tfuFirstName = jsonPath.getString("firstname");
        assertThat(tfuFirstName).contains("King").isNotBlank().isNotNull();
        String tfuLastName = jsonPath.getString("lastname");
        assertThat(tfuLastName).contains("Crown").isNotNull().isNotBlank();
    }

    @Test
    public void testFullyUpdatedBooking (){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);

        r = rs.when().log().all().get();

        vr = r.then().log().all().statusCode(200);

        String tfuResponse = r.asString();
        JsonPath jsonPath = new JsonPath(tfuResponse);

        String tfuFirstName = jsonPath.getString("firstname");
        assertThat(tfuFirstName).containsIgnoringCase("King");

        String tfuLastName = jsonPath.getString("lastname");
        assertThat(tfuLastName).containsIgnoringCase("Crown");

        Integer tfuTotalPrice = jsonPath.getInt("totalprice");
        assertThat(tfuTotalPrice).isEqualTo(777).isNotNull().isNotNegative().isNotZero();

        Boolean tfuDepositPaid = jsonPath.getBoolean("depositpaid");
        assertThat(tfuDepositPaid).isTrue();

        Object tfubookingDates = jsonPath.getJsonObject("bookingdates");
        assertThat(tfubookingDates).isNotNull();

        String tfucheckin = jsonPath.getJsonObject("bookingdates.checkin");
        assertThat(tfucheckin).isEqualTo("2018-01-01");

        String tfucheckout = jsonPath.getJsonObject("bookingdates.checkout");
        assertThat(tfucheckout).isEqualTo("2019-01-01");

        String tfuAdditionalNeeds = jsonPath.getString("additionalneeds");
        assertThat(tfuAdditionalNeeds).containsIgnoringCase("breakfast");
    }

    @Test(dependsOnGroups = {"Authentication.BookingId"}, dependsOnMethods = "testFullUpdate")
    public void testDeleteBooking (){
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path+"/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);

        r = rs.when().log().all().delete();

        vr = r.then().log().all().statusCode(201);

        //token = r.then().extract().path("token");

        String deleteResponse = r.asString();
        JsonPath jsonPath = new JsonPath(deleteResponse);
        System.out.println("This is the response, when deleted existing Booking :: "+jsonPath);
    }

    @Test
    public void testDeletedBookingInfo () {
        rs.baseUri(Base_Url);
        rs.basePath(Base_Path + "/" + bookingid);

        r = rs.when().log().all().get();

        vr = r.then().log().all().statusCode(404);

        String tdbResponse = r.asString();
        JsonPath jsonPath = new JsonPath(tdbResponse);
        System.out.println("This is the Response, when trying to get the Deleted Booking Info :: "+jsonPath);
    }
}
