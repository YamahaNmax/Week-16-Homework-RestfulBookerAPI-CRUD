package com.herokuapp.crudTest;

import com.herokuapp.model.BookingPojo;
import com.herokuapp.model.Bookingdates;
import com.herokuapp.model.TokenPojo;
import com.herokuapp.path.EndPoints;
import com.herokuapp.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CRUD {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;


    static String firstName = "Express" + TestUtils.getRandomValue();
    static String lastName = "Agent" + TestUtils.getRandomValue();
    static int totalPrice = 4444;
    static boolean depositPaid = true;
    static String checkIn = "2018-01-01";
    static String checkOut = "2018-01-14";
    static String additionalNeeds = "Breakfast";
    int bookingId;
    static String username = "admin";
    static String password = "password123";
    String authToken;


    @Test(priority = 1)
    public void getAllBookingIDs() {

        response = given().log().all()
                .when()
                .get(EndPoints.GET_ALL_BOOKING_IDS);
        response.then().log().all()
                .statusCode(200);
    }


    @Test(priority = 2)
    public void createBooking() {

        Bookingdates bookingDates = Bookingdates.getBookingDates(checkIn, checkOut);
        BookingPojo requestBody = BookingPojo.getRequestBody(firstName, lastName, totalPrice, depositPaid, bookingDates,
                additionalNeeds);

        response = given().log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(EndPoints.GET_ALL_BOOKING_IDS);
        response.then().log().all()
                .statusCode(200)
                .body("booking.firstname", equalTo(firstName))
                .body("booking.lastname", equalTo(lastName));
        bookingId = response.path("bookingid");
        System.out.println(bookingId);
    }

    @Test(priority = 3)
    public void getBookingById() {
        response = given().log().all()
                .when()
                .pathParams("id", bookingId)
                .get(EndPoints.GET_BOOKING_BY_ID);
        response.then().log().all().statusCode(200)
                .body("firstname", equalTo(firstName))
                .body("lastname", equalTo(lastName));
    }

    @Test(priority = 4)
    public void createToken() {

        TokenPojo tokenBody = TokenPojo.getTokenBody(username, password);

        response = given().log().all()
                .contentType(ContentType.JSON)
                .body(tokenBody)
                .when()
                .post(EndPoints.GET_AUTH_TOKEN);
        response.then().log().all()
                .statusCode(200);
        authToken = response.path("token");
        System.out.println(authToken);
    }


    @Test(priority = 4)
    public void partialUpdateBooking() {


        BookingPojo requestBody = BookingPojo.getPatchRequestBody(firstName + "zz", lastName + "zz");

        response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + authToken)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .pathParams("id", bookingId)
                .patch(EndPoints.GET_BOOKING_BY_ID);
        response.then().log().all()
                .statusCode(200);
        response.prettyPrint();
//                .body("firstname", equalTo(firstName + "zz"))
//                .body("lastname", equalTo(lastName + "zz"));
    }


    @Test(priority = 5)
    public void deleteBooking() {

        response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + authToken)
                .when()
                .pathParams("id", bookingId)
                .delete(EndPoints.GET_BOOKING_BY_ID);
        response.then().log().all().statusCode(201);





//        RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/22";
//        requestSpecification = RestAssured.given()
//                .header("Content-Type", "application/json")
//                .header("Cookie", "token=97dc4b7197026f8");
//        response = requestSpecification.delete();
//        System.out.println(response.prettyPrint());
//        validatableResponse = response.then();
//        validatableResponse.statusCode(201);

    }
}
