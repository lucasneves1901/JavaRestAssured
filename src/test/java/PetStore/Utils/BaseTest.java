package PetStore.Utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BaseTest {
    public static RequestSpecification reqSpec;
    public static ResponseSpecification repSpec;

    @BeforeClass
    public static void setUp() {
        baseURI = "https://restful-booker.herokuapp.com";

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.log(LogDetail.ALL);
        reqBuilder.setContentType(ContentType.JSON);
        reqSpec = reqBuilder.build();

        ResponseSpecBuilder repBuilder = new ResponseSpecBuilder();
        repBuilder.log(LogDetail.ALL);
        repBuilder.expectContentType(ContentType.JSON);
        repSpec = repBuilder.build();

        RestAssured.requestSpecification = reqSpec;
        RestAssured.responseSpecification = repSpec;
    }
}