package PetStore.Test;

import PetStore.Utils.BaseTest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class TestUpdateBooking extends BaseTest {
    @Test
    /*
    Updates a current booking
     */
    public void UpdateBooking() {
        Response response =
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
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .response();

        String IDValue = response.jsonPath().getString("bookingid");

        /*
        Needs Authentication
         */
        given()
                .pathParam("ID", IDValue)
                .body("{ " +
                        "\"firstname\": \"Lucas\", " +
                        "\"lastname\": \"Mace\", " +
                        "\"totalprice\": 2424, " +
                        "\"depositpaid\": true, " +
                        "\"bookingdates\": { " +
                        "\"checkin\": \"2023-06-01\", " +
                        "\"checkout\": \"2023-12-01\" " +
                        "}, " +
                        "\"additionalneeds\": \"Lunch\" " +
                        "}")
                .when()
                .put("/booking/{ID}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("additionalneeds", hasItem("Lunch"));
    }
}
