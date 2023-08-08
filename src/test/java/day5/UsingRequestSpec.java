package day5;

import files.Payload;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsingRequestSpec {

    RequestSpecification requestSpecification;

    @BeforeClass
    public void beforeclass() {
        requestSpecification = given().
                baseUri("https://restful-booker.herokuapp.com").
                contentType("application/json").accept("application/json");

    }
      @Test
      public  void addBooking(){
       given().spec(requestSpecification)
               .body(Payload.createbooking("Shalini","rai",150,false,"2023-01-01","2023-04-04","breakfast"))
               .when().post("/booking")
               .then()
               .log().all()
               .assertThat().statusCode(200);
    }
}
