package Booker.Test;

import Booker.Utils.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCreateBooking extends BaseTest {
    @Test
    /*
    Creates a new booking in the API
     */
    public void CreateBooking() {
        given()
                .body("{ " +
                        "\"firstname\": \"Lucas\", " +
                        "\"lastname\": \"Mace\", " +
                        "\"totalprice\": 2424, " +
                        "\"depositpaid\": true, " +
                        "\"bookingdates\": { " +
                        "\"checkin\": \"2023-01-01\", " +
                        "\"checkout\": \"2023-12-01\" " +
                        "}, " +
                        "\"additionalneeds\": \"Breakfast\" " +
                        "}")
                .when()
                .post("/booking")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}

