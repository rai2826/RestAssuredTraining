package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class DynamicJson {

    @Test
    public void addBooking(){

        RestAssured.baseURI="https://restful-booker.herokuapp.com";

        String res=given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .body(Payload.createbooking("Shalini","rai",150,false,"2023-01-01","2023-04-04","breakfast"))
        .when()
                .post("/booking")
        .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println(res);

        JsonPath js= new JsonPath(res);

        String fname=js.get("booking.firstname");
        System.out.println(fname);
        String checkindate=js.get("booking.bookingdates.checkin");
        System.out.println(checkindate);
    }
}
