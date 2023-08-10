package day5;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

public class UsingRequestSpecBuilder {

    @BeforeClass
    public void BeforeClass() {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://restful-booker.herokuapp.com");
        requestSpecBuilder.setContentType("application/json");
        requestSpecBuilder.setAccept("application/json");

        requestSpecification = requestSpecBuilder.build();

    }

    @Test
    public void addBooking() {
        Response response = given().spec(requestSpecification)
                .body(Payload.createbooking("Shalini", "rai", 150, false, "2023-01-01", "2023-04-04", "breakfast"))
                .when().post("/booking").then().log().all().extract().response();

        assertThat(response.statusCode(), is(200));


    }
}

