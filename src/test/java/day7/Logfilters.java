package day7;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;

public class Logfilters {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    File file;
    @BeforeClass
    public void setUp() throws FileNotFoundException {

        // Build Request and response spec using the builder
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
        requestSpecification=requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
        responseSpecification=responseSpecBuilder.build();

      // Use PrintStream class to log it in a file
        PrintStream filteroutstream=new PrintStream(("log.log"));

        requestSpecBuilder.addFilter(new RequestLoggingFilter(filteroutstream)).
                addFilter(new ResponseLoggingFilter(filteroutstream));
        
        // Set up the request and response specification
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        file= new File("C:\\Users\\d629263\\IdeaProjects\\RestAssuredTraining\\src\\test\\resources\\createbookingbody.json");
        //requestSpecification= given().log().all();
       // responseSpecification=RestAssured.expect().log().all();
        requestSpecification.contentType("application/json");
        requestSpecification.accept("application/json");
        responseSpecification.contentType("application/json");

    }


}
