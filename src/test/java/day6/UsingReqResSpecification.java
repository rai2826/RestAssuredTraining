package day6;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsingReqResSpecification {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    @BeforeClass
    public void setup(){
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.log().all();
        requestSpecification.basePath("/ping");
        requestSpecification.contentType("application/json");


       responseSpecification= RestAssured.expect();
       responseSpecification.statusCode(201);

    }

    @Test
    public void healthCheck(){

       Response response=RestAssured.given(requestSpecification).when().get();

        System.out.println("Status code returned is " + response.getStatusCode());


    }
}
