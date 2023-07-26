package Booker.Utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.baseURI;

public class BaseTest {
    public static RequestSpecification reqSpec;
    public static ResponseSpecification repSpec;

    @BeforeClass
    public static void setUp() {
        baseURI = "https://restful-booker.herokuapp.com";

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();

        reqBuilder
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .addHeader(Constants.AUTH_HEADER_NAME, "Basic " + Token.getToken());

        reqSpec = reqBuilder.build();

        ResponseSpecBuilder repBuilder = new ResponseSpecBuilder();

        repBuilder
                .log(LogDetail.ALL)
                .expectContentType(ContentType.JSON);

        repSpec = repBuilder.build();

        RestAssured.requestSpecification = reqSpec;
        RestAssured.responseSpecification = repSpec;
    }
}