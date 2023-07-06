package PetStore.Test;

import PetStore.Utils.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGetBooking extends BaseTest {
    @Test
    /*
    Returns the ids of all the bookings that exist within the API. Can take optional query strings to search
    and return a subset of booking ids.
    e.g.
    Filter by name '?firstname=sally&lastname=brown'
    Filter by checkIn '?checkIn=2014-03-13&checkout=2014-05-21'
    */
    public void GetBookingsIDs() {
        given()
                .when()
                .get("/booking")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    /*
    Returns a specific booking based upon the booking id provided
     */
    @Test
    public void GetBookingByID() {
        given()
                .pathParam("ID", 1540)
                .when()
                .get("/booking/{ID}")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
