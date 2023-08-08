package day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class CreatePostUsingOldMethod {


    @Test
    void testPostUsingJsonLib(){

        JSONObject data= new JSONObject();
        data.put("firstname","gaurav");
        data.put("lastname","rai");
        data.put("totalprice",130);
        data.put("depositpaid",true);

        JSONObject bdates=new JSONObject();
        bdates.put("checkin","2020-01-01");
        bdates.put("checkout","2020-02-02");

        data.put("bookingdates",bdates);
        data.put("additionalneeds","TV");

        Response res= RestAssured.given()
                .contentType("application/json")
                .accept("application/json")
                .body(data.toString()) // whenever you use Json object always convert it to String using "toString"
                .post("https://restful-booker.herokuapp.com/booking");

        res.print();

        Assert.assertEquals(res.statusCode(),200);
        String fname=res.jsonPath().getString("booking.firstname");

        System.out.println(fname);
        Assert.assertEquals(fname,"gaurav");



    }
}
