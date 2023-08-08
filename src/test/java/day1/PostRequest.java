package day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class PostRequest {

    int id;

    @Test(priority = 1)
    void createUser() {

        // Create test data using Hashmap

        HashMap data = new HashMap();
        data.put("name", "gaurav");
        data.put("job", "IT");


        id = given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");


        System.out.println(id);

    }

    @Test(priority = 2, dependsOnMethods = {"createUser"})
    void updateUser() {

        HashMap data = new HashMap();
        data.put("name", "gaurav");
        data.put("job", "Trainer");

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test(priority = 3)
    void deleteUser() {

        given()
                .when()
                .delete("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(204);

    }

}
