package day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class RestfulbookerHealthcheck {

    @Test
    void restfulbookerHealth()
    {

         given()

        .when()
                .get("https://restful-booker.herokuapp.com/ping")
        .then()
                .assertThat().statusCode(201)
                .log().all();

    }
}
