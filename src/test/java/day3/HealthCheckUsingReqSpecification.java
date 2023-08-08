package day3;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class HealthCheckUsingReqSpecification {

    @Test
    public void healthcheck() {
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();

        given()
                .spec(spec)
        .when()
                .get("/ping")
        .then()
                .statusCode(201);


    }
}