package day7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingUsingReusableclass extends Logfilters{

    @Test
    public void logginfFilter(){

        given(requestSpecification).body(file).when().post("/booking").
                then().spec(responseSpecification).assertThat().statusCode(200);

    }
}
