package SendingRequestMultipleWays;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SendingRequestUsingFile {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
     File file;
    @BeforeClass
    public void setup(){

         file= new File("C:\\Users\\d629263\\IdeaProjects\\RestAssuredTraining\\src\\test\\resources\\createbookingbody.json");
        requestSpecification= RestAssured.given().log().all();
        responseSpecification=RestAssured.expect().log().all();
        requestSpecification.contentType("application/json");
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.accept("application/json");
        responseSpecification.contentType("application/json");
    }

    @Test
    public void createBookingUsingFile(){

       Response response= requestSpecification.with().body(file).post("/booking");

        System.out.println(response.asPrettyString());

       assertThat(response.path("booking.firstname"),equalTo("Jim"));
       assertThat(response.statusCode(),equalTo(200));

    }
}
