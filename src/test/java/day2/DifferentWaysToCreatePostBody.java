package day2;



import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


/*
Different ways tp create POST request Body
1) Post request body creation using Hashmap
2) Post request body creation using Org.Json
3) Post request body creation using POJO class
4) Post request using external Json file data
 */
public class DifferentWaysToCreatePostBody {


    //1) Post request body creation using Hashmap

   //@Test
    void testPostUsingHashmap() {

        HashMap data1 = new HashMap();
        data1.put("firstname", "Scott");
        data1.put("lastname", "Scott");
        data1.put("totalprice", 111);
        data1.put("depositpaid", true);
        data1.put("bookingdates.checkin","2018-01-01");
        data1.put("bookingdates.checkout","2019-01-01");

        //String[] bookdate=new String[2];


         //data1.put("bookingdates", bookdate);
         data1.put("additionalneeds", "Breakfast");

        //System.out.println(bookdate);
       given()
                .contentType("application/json")
               .accept("application/json")
                .body(data1)
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                        .then()
                                .statusCode(200)
                                        .body("firstname",equalTo("Scott"))
               .log().all();


    }

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

        given()
                .contentType("application/json")
                .accept("application/json")
                .body(data.toString()) // whenever you use Json object always convert it to String using "toString"
        .when()
                .post("https://restful-booker.herokuapp.com/booking")
        .then()
                .assertThat().statusCode(200)
                .log().all();

    }
}
