package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;




public class HttpRequests {

    // we use BDD approach which helps with Gherkin keywords, RestAssured by default supports that
    //given()- content type,set cookies,add auth,set headers info etc
    //when() - request type i.e. get,post,put,delete
    //then() - all validations assertions here

    @Test
    void getUser() {

        given()

        .when()
                .get("https://reqres.in/api/users/928")

        .then()
                .statusCode(200)
                .log().all();


    }

}
