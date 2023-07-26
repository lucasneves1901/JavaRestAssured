package Booker.Utils;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;


public class Token {
    public static String getToken() {
        final JSONObject reqJson = new JSONObject();
        reqJson.put("username", "admin");
        reqJson.put("password", "password123");

        Response response =
                given()
                        .body(reqJson.toString())
                        .post("https://restful-booker.herokuapp.com/auth")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .response();

        return response.jsonPath().getString("token");
    }
}
